package org.example.movie

open class NewReleaseMovie(title: String, priceCode: Int) : Movie(title, priceCode) {
    override fun getRentalPrice(daysRented: Int): Double {
        return daysRented * 3.0
    }
}