package ui

sealed class UiState {
    object Empty : UiState()
    data class Error(val message: String) : UiState()
    data class Content(val booksInfo: String) : UiState()
}
