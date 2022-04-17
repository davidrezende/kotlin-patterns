package patterns.behavioral.chainOfResponsability

import domain.Ball
import domain.BallBrand
import domain.BallColor
import domain.BallType

interface HandlerBallValidatorChain {
    fun validate(obj: Ball): Boolean
}

class HandlerBallIsNikeBrand(var next: HandlerBallValidatorChain? = null) : HandlerBallValidatorChain {
    override fun validate(obj: Ball): Boolean {
        if (obj.brand != BallBrand.NIKE) {
            println("HandlerBallIsNikeBrand false")
            return false
        } else {
            return next?.validate(obj) ?: true
        }
    }
}

class HandlerBallIsBasketBall(var next: HandlerBallValidatorChain? = null) : HandlerBallValidatorChain {
    override fun validate(obj: Ball): Boolean {
        if (obj.type != BallType.BASKETBALL) {
            println("HandlerBallIsBasketBall false")
            return false
        } else {
            return next?.validate(obj) ?: true
        }
    }
}

class HandlerBallIsBlue(var next: HandlerBallValidatorChain? = null) : HandlerBallValidatorChain {
    override fun validate(obj: Ball): Boolean {
        if (obj.color != BallColor.BLUE) {
            println("HandlerBallIsBlue false")
            return false
        } else {
            return next?.validate(obj) ?: true
        }
    }
}


fun main() {
    val ballIsNikeBrand = HandlerBallIsNikeBrand()
    val ballIsBasketBall = HandlerBallIsBasketBall()
    val ballIsBlue = HandlerBallIsBlue()

    ballIsNikeBrand.next = ballIsBasketBall
    ballIsBasketBall.next = ballIsBlue

    val ball = Ball(BallColor.BLUE, BallBrand.NIKE, BallType.BASKETBALL)
    val resultado = ballIsNikeBrand.validate(ball)
    println("Ball is valid")
    println(resultado)

    val ball2 = Ball(BallColor.RED, BallBrand.NIKE, BallType.BASKETBALL)
    val resultado2 = ballIsNikeBrand.validate(ball2)
    //unreachable code
    println("Ball is not valid")
    println(resultado2)

}