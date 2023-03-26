package domain

import domain.model.Book
import domain.model.Customer
import domain.model.Employee
import domain.model.Order

interface BookRepository {
    fun getBooks(): List<Book>
    fun getCustomers(): List<Customer>
    fun getEmployees(): List<Employee>
    fun getOrders(): List<Order>
}