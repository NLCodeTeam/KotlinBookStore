package domain

import domain.model.BookAdditional
import domain.model.BookGenre
import domain.model.Profit

interface BookUseCase {
    fun getMostPopularGenreLessThenAge(age: Int): BookGenre
    fun getMostPopularGenreMoreThenAge(age: Int): BookGenre
    fun getCountOfSoldBooksByGenre(): List<BookAdditional>
    fun getPriceOfSoldBooksByGenre(): Map<BookGenre, Int>
    fun getProfitByEmployee(employeeId: Long): Profit
    fun getAllPriceOfSoldBooks(): Int
    fun getCountOfSoldBooks(): Int
}