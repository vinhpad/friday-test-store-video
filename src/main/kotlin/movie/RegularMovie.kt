package org.example.movie

open class RegularMovie (title: String, priceCode: Int) : Movie(title, priceCode) {
    override fun getRentalPrice(daysRented: Int): Double {
        var rentalPrice = 2.0
        if (daysRented > 2)
            rentalPrice += (daysRented - 2) * 1.5
        return rentalPrice
    }
}