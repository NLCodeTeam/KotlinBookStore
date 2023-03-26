package data.repository

import data.map
import data.source.BookDataSource
import data.source.BookDataSourceImpl
import domain.BookRepository
import domain.model.Book
import domain.model.Customer
import domain.model.Employee
import domain.model.Order


class BookRepositoryImpl(private val dataSource: BookDataSource) : BookRepository {
    override fun getBooks(): List<Book> = dataSource.getBooks().map { it.map() }

    override fun getCustomers(): List<Customer> = dataSource.getCustomers().map { it.map() }

    override fun getEmployees(): List<Employee> = dataSource.getEmployees().map { it.map() }

    override fun getOrders(): List<Order> = dataSource.getOrders().map { it.map() }

    companion object {
        fun createDataSource(): BookDataSource = BookDataSourceImpl()
    }
}