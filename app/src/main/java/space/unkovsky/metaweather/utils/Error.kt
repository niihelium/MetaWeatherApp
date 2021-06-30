package space.unkovsky.metaweather.utils

sealed class Error {
    data class NetworkError(val error: String = "") : Error()
}