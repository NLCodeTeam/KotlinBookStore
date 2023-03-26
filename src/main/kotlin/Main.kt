fun main(args: Array<String>) {

    val calculator = PriceCalculator()
    calculator.calculate(FixDiscount(0.3f, 1000.0))

    calculator.calculate(ComplexDiscount(1200.0, 1500.0, 1400.0))
}

interface Discount {
    fun apply(): Double
}

class FixDiscount(private val discount: Float, private val price: Double) : Discount {

    override fun apply(): Double {
        return price - price * discount
    }
}

class ComplexDiscount(private val price1: Double, private val price2: Double, private val price3: Double) : Discount {
    override fun apply(): Double {
        return price1 + price2 + price3 - min(price1, price2, price3)
    }
}

fun min(price1: Double, price2: Double, price3: Double): Double {
    val min = if (price1 <= price2) price1 else price2
    return if (min <= price3) min else price3
}

class PriceCalculator {
    fun calculate(discount: Discount) = discount.apply()
}

/* // задача№1
    println(adapter.getBooksInfo())

    // задача №2
    adapter.getProfitByEmployee().forEach { println(it) }

    // задача №3
    adapter.countAndPriceBooksByGenre().forEach { println(it) }

    // задача №4
    val age = 30
    println(adapter.getMostPopularGenreLessThenAge(age))

    // задача №5
    println(adapter.getMostPopularGenreMoreThenAge(age))*/