package com.memije.pdxcore.utils.extensions

fun Int.toFormatNumber(): String = "Nº${this.coerceAtLeast(0).toThreeDigits()}"

private fun Int.toThreeDigits(): String = "%03d".format(this)
