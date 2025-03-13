package org.example.movie

open class ChildrenMovie(title: String, priceCode: Int) : Movie(title, priceCode){
    override fun getRentalPrice(daysRented: Int): Double {
        var rentalPrice = 1.5
        if (daysRented > 3)
            rentalPrice += (daysRented - 3) * 1.5

        return rentalPrice
    }

}