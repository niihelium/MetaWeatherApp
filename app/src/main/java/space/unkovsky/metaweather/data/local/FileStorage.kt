package space.unkovsky.metaweather.data.local

import java.io.File
import javax.inject.Inject

class FileStorage @Inject constructor(
    private val cacheDir: File

) {
    fun getIcon(abbreviation: String): ByteArray {
        return File(cacheDir, abbreviation).readBytes()
    }

    fun isIconExist(abbreviation: String): Boolean {
        return cacheDir.list()
            .filter { it == abbreviation }
            .any()
    }

    fun saveIcon(abbreviation: String, contents: ByteArray) {
        File.createTempFile(abbreviation, null, cacheDir).outputStream().use {
            it.write(contents)
        }
    }

}
