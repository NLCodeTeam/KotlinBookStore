package domain.model

data class Book(val id: Long, val title: String, val author: String, val price: Int, val genre: BookGenre)