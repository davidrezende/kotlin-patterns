package patterns.structural.adapter

interface Duck {
    fun fly()

    fun quack()
}

interface Turkey {
    fun turkeyFly()

    fun gobble()
}


class WildDuck: Duck {
    override fun fly() {
        println("I'm flying as a duck!")
    }

    override fun quack() {
        println("I'm quacking!")
    }
}

class CoolTurkey: Turkey {
    override fun turkeyFly() {
        println("I'm flying as turkey")
    }

    override fun gobble() {
        println("I'm gobbling!")
    }
}

// Client knows how to speak with a DUCK. But we have Turkey as a final class. Hence use Adapter to convert response from a DUCK to TURKEY
class TurkeyAdapter(turkey: Turkey): Duck {
    val currentTurkey: Turkey = turkey

    override fun fly() {
        currentTurkey.turkeyFly()
    }

    override fun quack() {
        currentTurkey.gobble()
    }
}

fun main() {
    val ourTurkey = CoolTurkey()
    val wrappedTurkey = TurkeyAdapter(ourTurkey)
    wrappedTurkey.fly()
    wrappedTurkey.quack()
}
