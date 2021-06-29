package space.unkovsky.metaweather

import android.text.SpannableString
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.lifecycle.MutableLiveData

fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

fun Float.toTemp(): String {
    val string = this.toInt().toString()
    return if (string.startsWith("-")) string else "+$string"
}

fun markText(string: String, substring: String): Spanned {
    if (substring.isBlank()) return SpannableString(string)

    val stringDown = string.lowercase()
    val substringDown = substring.lowercase()

    val index = stringDown.indexOf(substringDown)

    val (start, middle, end) = when {
        index > 0 -> {
            listOf(
                string.substring(0 until index),
                string.substring(index until index + substring.length),
                string.substring(index + substring.length)
            )
        }
        stringDown.startsWith(substringDown) -> {
            listOf(
                "",
                string.substring(0 until substring.length),
                string.substring(substring.length)
            )
        }
        else -> {
            listOf(string, "", "")
        }
    }
    return HtmlCompat.fromHtml(
        "${start}<b>${middle}</b>${end}",
        HtmlCompat.FROM_HTML_MODE_COMPACT
    )
}