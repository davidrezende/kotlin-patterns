package patterns.behavioral.chainOfResponsability

import Ball

interface HandlerBallValidatorChain {
    fun validate(obj: Ball)
}

class HandlerBallIsNikeBrand(var next: HandlerBallValidatorChain? = null) : HandlerBallValidatorChain{
    override fun validate(obj: Ball){
        if(obj.brand != BallBrand.NIKE){
            throw Exception("Ball ${obj.brand} is not valid")
        }else{
            next?.validate(obj)
        }
    }
}

class HandlerBallIsBasketBall(var next: HandlerBallValidatorChain? = null) : HandlerBallValidatorChain{
    override fun validate(obj: Ball){
        if(obj.type != BallType.BASKETBALL){
            throw Exception("Ball of ${obj.type} is not valid")
        }else{
            next?.validate(obj)
        }
    }
}

class HandlerBallIsBlue(var next: HandlerBallValidatorChain? = null) : HandlerBallValidatorChain{
    override fun validate(obj: Ball){
        if(obj.color != BallColor.BLUE){
            throw Exception("Ball ${obj.color} is not valid")
        }else{
            next?.validate(obj)
        }
    }
}


fun main() {
    val ballSoccerAndNikeBrand = HandlerBallIsNikeBrand()
    val ballIsBasketBall = HandlerBallIsBasketBall()
    val ballIsBlue = HandlerBallIsBlue()

    ballSoccerAndNikeBrand.next = ballIsBasketBall
    ballIsBasketBall.next = ballIsBlue

    val ball = Ball(BallColor.BLUE, BallBrand.NIKE, BallType.BASKETBALL)
    ballSoccerAndNikeBrand.validate(ball)
    println("Ball is valid")

    val ball2 = Ball(BallColor.RED, BallBrand.NIKE, BallType.BASKETBALL)
    ballSoccerAndNikeBrand.validate(ball2)
    //unreachable code
    println("Ball is valid")

}