package domain

import domain.model.*

class BookUseCaseImpl(private val repository: BookRepository) : BookUseCase {

    // наиболее популярный жанр по возрасту lj age
    override fun getMostPopularGenreLessThenAge(age: Int): BookGenre {
        val customerIds = repository.getCustomers()
            .filter { it.age < age }
            .map { it.id }
        return getMostPopularBookGenre(customerIds)
    }

    // наиболее популярный жанр по возрасту старше age
    override fun getMostPopularGenreMoreThenAge(age: Int): BookGenre {
        val customerIds = repository.getCustomers().filter { it.age > age }.map { it.id }
        return getMostPopularBookGenre(customerIds)
    }

    // количестов книг по жанру
    override fun getCountOfSoldBooksByGenre(): List<BookAdditional> {
        fun genreCount(genre: BookGenre) =
            repository.getOrders().sumOf { getCountOfSoldByGenre(it, genre) }

        return listOf(
            BookAdditional(BookGenre.Art, genreCount(BookGenre.Art)),
            BookAdditional(BookGenre.Programming, genreCount(BookGenre.Programming)),
            BookAdditional(BookGenre.Physhology, genreCount(BookGenre.Physhology))
        )
    }

    // получить стоимость проданных книг по жанрам
    override fun getPriceOfSoldBooksByGenre(): Map<BookGenre, Int> {

        fun genrePrice(genre: BookGenre) =
            repository.getOrders().sumOf { getPriceOfSoldByGenre(it, genre) }

        return hashMapOf(
            Pair(BookGenre.Art, genrePrice(BookGenre.Art)),
            Pair(BookGenre.Programming, genrePrice(BookGenre.Programming)),
            Pair(BookGenre.Physhology, genrePrice(BookGenre.Physhology))
        )
    }

    override fun getProfitByEmployee(employeeId: Long): Profit {
        val profitOrders = repository.getOrders().filter { it.employeeId == employeeId }

        return Profit(
            price = profitOrders.sumOf { getPriceOfSoldBooksInOrder(it) },
            count = profitOrders.sumOf { it.books.size }
        )
    }

    // получить общую сумму заказов
    override fun getAllPriceOfSoldBooks(): Int = repository.getOrders().sumOf { getPriceOfSoldBooksInOrder(it) }

    // получить все проданные книги
    override fun getCountOfSoldBooks(): Int = repository.getOrders().sumOf { it.books.size }

    private fun getMostPopularBookGenre(customerIds: List<Long>): BookGenre {

        fun countFilteredOrders(genre: BookGenre) =
            repository.getOrders()
                .filter { customerIds.contains(it.customerId) }
                .sumOf { getCountOfSoldByGenre(it, BookGenre.Art) }


        val result = listOf(
            BookAdditional(BookGenre.Art, countFilteredOrders(BookGenre.Art)),
            BookAdditional(BookGenre.Programming, countFilteredOrders(BookGenre.Programming)),
            BookAdditional(BookGenre.Physhology, countFilteredOrders(BookGenre.Physhology))
        ).sortedByDescending { it.count }.first()

        return result.genre
    }

    // получить количество книг в одном заказе по жанру
    private fun getCountOfSoldByGenre(order: Order, genre: BookGenre): Int =
        order.books
            .map { getBookById(it) }
            .count { it != null && it.genre == genre }

    // получить общую сумму книг в одном заказе по жанру
    private fun getPriceOfSoldByGenre(order: Order, genre: BookGenre): Int =
        order.books
            .map { getBookById(it) }
            .filter { it != null && it.genre == genre }
            .filterNotNull()
            .sumOf { it.price }

    // get book by Id
    private fun getBookById(id: Long): Book? = repository.getBooks().find { it.id == id }

    private fun getPriceOfSoldBooksInOrder(order: Order): Int =
        order.books
            .map { getBookById(it) }
            .filterNotNull()
            .sumOf { it.price }
}