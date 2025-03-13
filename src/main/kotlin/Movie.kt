package org.example

class Movie(val title: String, var priceCode: Int) {
    companion object {
        const val CHILDRENS: Int = 2
        const val NEW_RELEASE: Int = 1
        const val REGULAR: Int = 0
    }
}