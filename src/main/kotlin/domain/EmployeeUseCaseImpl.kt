package domain

import domain.model.Employee

class EmployeeUseCaseImpl(private val repository: BookRepository) : EmployeeUseCase {
    override fun getEmployees(): List<Employee> = repository.getEmployees()
}