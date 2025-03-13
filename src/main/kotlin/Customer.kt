package org.example

import org.example.movie.Movie


class Customer(val name: String) {
    private val rentals: MutableList<Rental> = mutableListOf()

    fun addRental(arg: Rental) {
        rentals.add(arg)
    }

    fun statement(): String {
        var totalAmount = 0.0
        var frequentRenterPoints = 0
        var result = "Rental Record for $name\n"

        for (each in rentals) {
            var thisAmount = 0.0
            var movie = each.movie.factory()

            // determine amounts for each line
//            when (each.movie.priceCode) {
//
//                Movie.REGULAR -> {
//                    thisAmount += 2.0
//                    if (each.daysRented > 2) {
//                        thisAmount += (each.daysRented - 2) * 1.5
//                    }
//                }
//
//                Movie.NEW_RELEASE -> {
//                    thisAmount += each.daysRented * 3.0
//                }
//
//                Movie.CHILDRENS -> {
//                    thisAmount += 1.5
//                    if (each.daysRented > 3) {
//                        thisAmount += (each.daysRented - 3) * 1.5
//                    }
//                }
//            }

            thisAmount += movie.getRentalPrice(each.daysRented)

            // add frequent renter points
            frequentRenterPoints++

            // add bonus for a two-day new release rental
            if ((movie.priceCode == Movie.NEW_RELEASE) && each.daysRented > 1) frequentRenterPoints++

            // show figures for this rental
            result += "\t" + each.movie.title + "\t" + thisAmount.toString() + "\n"
            totalAmount += thisAmount
        }

        // add footer lines
        result += "Amount owed is $totalAmount\n"
        result += "You earned $frequentRenterPoints frequent renter points"

        return result
    }
}