package com.memije.pdxcore.network.model

sealed class PDXResponseGeneric<out T> {
    data class Success<T>(val data: T) : PDXResponseGeneric<T>()
    data class Error(val message: String, val exception: Throwable? = null) : PDXResponseGeneric<Nothing>()
    data object Loading : PDXResponseGeneric<Nothing>()
}