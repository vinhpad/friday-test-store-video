import org.example.Customer
import org.example.movie.Movie
import org.example.Rental
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test


class MainTest {
    @Test
    fun baseTest() {
        val customer = Customer("Bob")
        customer.addRental(Rental(Movie("Jaws", Movie.REGULAR), 2))
        customer.addRental(Rental(Movie("Golden Eye", Movie.REGULAR), 3))
        customer.addRental(Rental(Movie("Short New", Movie.NEW_RELEASE), 1))
        customer.addRental(Rental(Movie("Long New", Movie.NEW_RELEASE), 2))
        customer.addRental(Rental(Movie("Bambi", Movie.CHILDRENS), 3))
        customer.addRental(Rental(Movie("Toy Story", Movie.CHILDRENS), 4))

        val expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points"

        assertEquals(expected, customer.statement())
    }

    @Test
    fun testRegularMovie() {
        val customer = Customer("Alice")
        customer.addRental(Rental(Movie("The Matrix", Movie.REGULAR), 1))
        val expected = "Rental Record for Alice\n\tThe Matrix\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points"
        assertEquals(expected, customer.statement())
    }

    @Test
    fun testNewReleaseMovie() {
        val customer = Customer("Bob")
        customer.addRental(Rental(Movie("Avengers: Endgame", Movie.NEW_RELEASE), 3))
        val expected = "Rental Record for Bob\n\tAvengers: Endgame\t9.0\nAmount owed is 9.0\nYou earned 2 frequent renter points"
        assertEquals(expected, customer.statement())
    }

    @Test
    fun testChildrensMovie() {
        val customer = Customer("Charlie")
        customer.addRental(Rental(Movie("Frozen", Movie.CHILDRENS), 4))
        val expected = "Rental Record for Charlie\n\tFrozen\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points"
        assertEquals(expected, customer.statement())
    }

    @Test
    fun testMultipleMovies() {
        val customer = Customer("Dave")
        customer.addRental(Rental(Movie("The Matrix", Movie.REGULAR), 1))
        customer.addRental(Rental(Movie("Avengers: Endgame", Movie.NEW_RELEASE), 3))
        customer.addRental(Rental(Movie("Frozen", Movie.CHILDRENS), 4))
        val expected = "Rental Record for Dave\n\tThe Matrix\t2.0\n\tAvengers: Endgame\t9.0\n\tFrozen\t3.0\nAmount owed is 14.0\nYou earned 4 frequent renter points"
        assertEquals(expected, customer.statement())

        customer.addRental(Rental(Movie("Toy Story", Movie.CHILDRENS), 4))
        val expected2 = "Rental Record for Dave\n\tThe Matrix\t2.0\n\tAvengers: Endgame\t9.0\n\tFrozen\t3.0\n\tToy Story\t3.0\nAmount owed is 17.0\nYou earned 5 frequent renter points"
        assertEquals(expected2, customer.statement())
    }

    @Test
    fun testZeroDaysRented() {
        val customer = Customer("Eve")
        customer.addRental(Rental(Movie("The Matrix", Movie.REGULAR), 0))
        val expected = "Rental Record for Eve\n\tThe Matrix\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points"
        assertEquals(expected, customer.statement())
    }

    @Test
    fun testNegativeDaysRented() {
        val customer = Customer("Frank")
        try {
            customer.addRental(Rental(Movie("The Matrix", Movie.REGULAR), -1))
        } catch (e: IllegalArgumentException) {
            assertEquals("Days rented cannot be negative: -1", e.message)
        }
    }

    @Test
    fun testInvalidPriceCode() {
        val customer = Customer("Grace")
        try {
            customer.addRental(Rental(Movie("Unknown Movie", 999), 1))
        } catch (e: IllegalArgumentException) {
            assertEquals("Invalid price code: 999", e.message)
        }
    }

}