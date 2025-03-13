package org.example.movie

open class Movie(var title: String,var priceCode: Int) : MovieRental {
    companion object {
        const val CHILDRENS: Int = 2
        const val NEW_RELEASE: Int = 1
        const val REGULAR: Int = 0
    }

    public fun factory() : Movie {
        when (priceCode) {
            NEW_RELEASE -> return NewReleaseMovie(title, priceCode)
            REGULAR -> return RegularMovie(title, priceCode)
            CHILDRENS -> return ChildrenMovie(title, priceCode)
            else -> {
                throw IllegalArgumentException("Incorrect Price Code")
            }
        }
    }

    override fun getRentalPrice(daysRented: Int): Double {
        return 0.0;
    }
}