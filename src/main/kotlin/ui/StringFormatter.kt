package ui


class StringFormatter {

    fun format(formatted: String, args: Array<Any>) = String.format(formatted, *args)
}