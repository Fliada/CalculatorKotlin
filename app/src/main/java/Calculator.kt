abstract class Calculator {
    abstract val sign: Char
    abstract fun Calculate(first: Double, second: Double) : Double
}

class Multiplication : Calculator() {
    override val sign: Char = '×'
    override fun Calculate(first: Double, second: Double): Double {
        return first * second
    }
}

class Division : Calculator() {
    override val sign: Char = '÷'
    override fun Calculate(first: Double, second: Double): Double {
        return first / second
    }
}

class Addition : Calculator() {
    override val sign: Char = '+'
    override fun Calculate(first: Double, second: Double): Double {
        return first + second
    }
}

class Substraction : Calculator() {
    override val sign: Char = '-'
    override fun Calculate(first: Double, second: Double): Double {
        return first - second
    }
}