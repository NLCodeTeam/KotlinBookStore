package data

import data.model.BookDto
import data.model.CustomerDto
import data.model.EmployeeDto
import data.model.OrderDto
import domain.model.*

fun Book.map() = BookDto(
    id = id,
    title = title,
    author = author,
    price = price,
    genreStr = genre.name
)

fun BookDto.map() = Book(
    id = id,
    title = title,
    author = author,
    price = price,
    genre = BookGenre.from(genreStr)
)

fun Customer.map() = CustomerDto(
    id = id,
    name = name,
    age = age
)

fun CustomerDto.map() = Customer(
    id = id,
    name = name,
    age = age
)

fun Employee.map() = EmployeeDto(
    id = id,
    name = name,
    age = age
)

fun EmployeeDto.map() = Employee(
    id = id,
    name = name,
    age = age
)

fun Order.map() = OrderDto(
    id = id,
    customerId = customerId,
    employeeId = employeeId,
    books = books
)

fun OrderDto.map() = Order(
    id = id,
    customerId = customerId,
    employeeId = employeeId,
    books = books
)