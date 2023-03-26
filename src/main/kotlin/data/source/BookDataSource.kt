package data.source

import data.model.BookDto
import data.model.CustomerDto
import data.model.EmployeeDto
import data.model.OrderDto


interface BookDataSource {
    fun getBooks(): List<BookDto>
    fun getCustomers(): List<CustomerDto>
    fun getEmployees(): List<EmployeeDto>
    fun getOrders(): List<OrderDto>
}