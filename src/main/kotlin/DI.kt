import data.BookDataSourceFactory
import data.repository.BookRepositoryImpl
import data.source.BookDataSource
import domain.*
import ui.BookAdapter
import ui.StringFormatter

object DI {

    // для слоя Data
    fun createDataSource(): BookDataSource = BookDataSourceFactory.create()

    fun createRepository(): BookRepository = BookRepositoryImpl(createDataSource())

    // для слоя Domain
    fun createBookUseCase(): BookUseCase = BookUseCaseImpl(createRepository())

    fun createEmployeeUseCase(): EmployeeUseCase = EmployeeUseCaseImpl(createRepository())

    // для слоя UI
    fun createStringFormatter() = StringFormatter()

    fun createBookAdapter() = BookAdapter(
        bookUseCase = createBookUseCase(),
        employeeUseCase = createEmployeeUseCase(),
        stringFormatter = createStringFormatter()
    )
}