package patterns.behavioral.chainOfResponsability

interface HandlerChain {
    fun withdraw(value: Int)
}

class Handler50Real : HandlerChain {
    private var nextHandler: HandlerChain? = null

    override fun withdraw(value: Int) {
        println("Trying withdraw value with only notes of 50 reais")
        if (value.mod(50) == 0) {
            println("Yes! Withdraw is possible with same notes of 50 reais")
        } else {
            nextHandler?.withdraw(value)
        }
    }

    fun setNextHandler(handler: HandlerChain) {
        nextHandler = handler
    }
}

class Handler20Real : HandlerChain {
    private var nextHandler: HandlerChain? = null

    override fun withdraw(value: Int) {
        println("Trying withdraw value with only notes of 20 reais")
        if (value.mod(20) == 0) {
            println("Yes! Withdraw is possible with same notes of 20 reais")
        } else {
            nextHandler?.withdraw(value)
        }
    }

    fun setNextHandler(handler: HandlerChain) {
        nextHandler = handler
    }
}

class Handler10Real : HandlerChain {
    private var nextHandler: HandlerChain? = null

    override fun withdraw(value: Int) {
        println("Trying withdraw value with only notes of 10 reais")
        if (value.mod(10) == 0) {
            println("Yes! Withdraw is possible with same notes of 10 reais")
        } else {
            nextHandler?.withdraw(value)
        }
    }

    fun setNextHandler(handler: HandlerChain) {
        nextHandler = handler
    }
}

class Handler5Real : HandlerChain {
    private var nextHandler: HandlerChain? = null

    override fun withdraw(value: Int) {
        println("Trying withdraw value with only notes of 5 real")
        if (value.mod(5) == 0) {
            println("Yes! Withdraw is possible with same notes of 5 reais")
        } else {
            nextHandler?.withdraw(value)
        }
    }

    fun setNextHandler(handler: HandlerChain) {
        nextHandler = handler
    }
}

fun main() {
    val handler50Real = Handler50Real()
    val handler20Real = Handler20Real()
    val handler10Real = Handler10Real()
    val handler5Real = Handler5Real()

    handler50Real.setNextHandler(handler20Real)
    handler20Real.setNextHandler(handler10Real)
    handler10Real.setNextHandler(handler5Real)

    println("Trying withdraw 106 reais")
    handler50Real.withdraw(106)
    println("Trying withdraw 900 reais")
    handler50Real.withdraw(900)
    println("Trying withdraw 105 reais")
    handler50Real.withdraw(105)
}