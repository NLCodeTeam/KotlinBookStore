package ui

interface Observer<T> {
    fun onChanged(arg: T)
}