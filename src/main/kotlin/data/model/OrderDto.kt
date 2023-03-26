package data.model

class OrderDto(val id: Long, val customerId: Long, val employeeId: Long, val books: LongArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrderDto

        if (id != other.id) return false
        if (customerId != other.customerId) return false
        if (employeeId != other.employeeId) return false
        if (!books.contentEquals(other.books)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + customerId.hashCode()
        result = 31 * result + employeeId.hashCode()
        result = 31 * result + books.contentHashCode()
        return result
    }
}