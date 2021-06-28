package space.unkovsky.metaweather

import androidx.lifecycle.MutableLiveData

fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

fun Float.toTemp(): String {
    val string = this.toInt().toString()
    return if (string.startsWith("-")) string else "+$string"
}