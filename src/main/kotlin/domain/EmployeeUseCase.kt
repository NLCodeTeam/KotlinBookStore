package domain

import domain.model.Employee

interface EmployeeUseCase {
    fun getEmployees(): List<Employee>
}