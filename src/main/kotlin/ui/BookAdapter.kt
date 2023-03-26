package ui

import domain.BookUseCase
import domain.EmployeeUseCase

class BookAdapter(
    private val bookUseCase: BookUseCase,
    private val employeeUseCase: EmployeeUseCase,
    private val stringFormatter: StringFormatter
) {

    val booksInfo: Observable<UiState> = Observable()
    //val profitByEmployee: Observable<List<String>> = Observable()

    fun updateBooksInfo() {
        booksInfo.observerValue = try {
            val info = getBooksInfo()
            if (info.isNotEmpty()) {
                UiState.Content(booksInfo = info)
            } else {
                UiState.Empty
            }

        } catch (e: IllegalArgumentException) {
            UiState.Error(e.message.orEmpty())
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun getBooksInfo(): String {

        return ""
        /*stringFormatter.format(
            BOOKS_INFO,
            arrayOf(bookUseCase.getCountOfSoldBooks(), bookUseCase.getAllPriceOfSoldBooks())
        )*/
    }

    /* fun updateProfitByEmployee() {
         profitByEmployee.observerValue = employeeUseCase.getEmployees().map {
             stringFormatter.format(EMPLOYEE_SOLD, arrayOf(it.name, bookUseCase.getProfitByEmployee(it.id).price))
         }
     }

     fun getProfitByEmployee(): List<String> = employeeUseCase.getEmployees().map {
         stringFormatter.format(EMPLOYEE_SOLD, arrayOf(it.name, bookUseCase.getProfitByEmployee(it.id).price))
     }



     fun getMostPopularGenreLessThenAge(age: Int) = stringFormatter.format(
         ANALYZE_GENRE_LESS,
         arrayOf(age, bookUseCase.getMostPopularGenreLessThenAge(age).name)
     )

     fun getMostPopularGenreMoreThenAge(age: Int) = stringFormatter.format(
         ANALYZE_GENRE_MORE,
         arrayOf(age, bookUseCase.getMostPopularGenreMoreThenAge(age).name)
     )

     fun countAndPriceBooksByGenre(): List<String> =
         bookUseCase.getCountOfSoldBooksByGenre().map {
             stringFormatter.format(
                 SOLD_BOOKS,
                 arrayOf(it.genre.name, it.count, bookUseCase.getPriceOfSoldBooksByGenre()[it.genre] ?: 0)
             )
         }*/

    companion object {
        private const val BOOKS_INFO = "Общее количество проданных книг %d на сумму %d"
        private const val SOLD_BOOKS = "По жанру: %s продано %d книг общей стоимостью %d"
        private const val ANALYZE_GENRE_LESS = "Покупатели до %d лет выбирают жанр %s"
        private const val ANALYZE_GENRE_MORE = "Покупатели старше %d лет выбирают жанр %s"
        private const val EMPLOYEE_SOLD = "%s продал(а) %d"
    }
}