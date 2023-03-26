package domain.model

enum class BookGenre {
    Art,  // художественная
    Programming,  // программирование
    Physhology; // психология

    companion object {
        fun from(source: String): BookGenre {
            return values().firstOrNull { it.name == source } ?: Art
        }
    }
}