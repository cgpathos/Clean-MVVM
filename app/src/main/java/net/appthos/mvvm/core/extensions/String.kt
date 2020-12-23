package net.appthos.mvvm.core.extensions

fun String.safeColorHex() : String {
    return if (this.startsWith("#")) this else "#$this"
}