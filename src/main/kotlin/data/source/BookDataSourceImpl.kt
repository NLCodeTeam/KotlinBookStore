package data.source

import data.model.BookDto
import data.model.CustomerDto
import data.model.EmployeeDto
import data.model.OrderDto


class BookDataSourceImpl : BookDataSource {

    override fun getBooks(): List<BookDto> = listOf(
        BookDto(1, "Financist", "Teodor Draizer", 1600, "Art"),
        BookDto(2, "War and Piece", "Tolstoy Lec", 1500, "Art"),
        BookDto(3, "Dead soul", "Dostoevsky Fedor", 1300, "Art"),
        BookDto(4, "Man and woman", "Fraid Zigmond", 1200, "Physhology"),
        BookDto(5, "Manipulation and actualization", "Everett Shostorm", 1150, "Physhology"),
        BookDto(6, "C++ start", "Zinich Roman", 1100, "Programming")
    )

    override fun getCustomers(): List<CustomerDto> = listOf(
        CustomerDto(1, "Sidorov Alex", 25),
        CustomerDto(2, "Romanov Ivan", 32),
        CustomerDto(3, "Simovon Eldar", 18)
    )

    override fun getEmployees(): List<EmployeeDto> = listOf(
        EmployeeDto(1, "Maria Ivanova", 37),
        EmployeeDto(2, "Ivan Ivanov", 47),
        EmployeeDto(3, "Serg Ivanov", 57)
    )

    override fun getOrders(): List<OrderDto> = listOf(
        OrderDto(1, 1, 1, longArrayOf(1, 2, 3)),
        OrderDto(2, 2, 2, longArrayOf(2, 3, 4)),
        OrderDto(3, 3, 3, longArrayOf(4, 5, 6))
    )
}