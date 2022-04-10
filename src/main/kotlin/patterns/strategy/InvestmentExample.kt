package patterns.strategy

import domain.Order
import domain.ProductInvestment
import java.math.BigDecimal
import java.util.*

interface OrderStrategy {
    open var type: ProductInvestment
}

interface BuyOrderStrategy : OrderStrategy {
    abstract fun buy(order: Order): Order
}

class CdbStrategyImpl : BuyOrderStrategy {
    override var type = ProductInvestment.CDB

    override fun buy(order: Order): Order {
        println("Cdb Implementantion")
        return Order(
            id = order.id,
            name = order.name,
            value = order.value,
        )
    }
}

class FundsStrategyImpl() : BuyOrderStrategy {
    override var type = ProductInvestment.FUNDS

    override fun buy(order: Order): Order {
        println("Funds Implementantion")
        return Order(
            id = order.id,
            name = order.name,
            value = order.value,
        )
    }
}

//Context
fun main() {
    val randomOrder = Order(
        id = UUID.randomUUID(),
        name = ProductInvestment.valueOf(listOf("CDB", "FUNDS").random()),
        value = BigDecimal.valueOf(1000.00)
    )
    println(randomOrder)
    val strategy = choiceStrategy(randomOrder.name.value)
    println(strategy.buy(randomOrder))

}

private fun choiceStrategy(type: String): BuyOrderStrategy {
    val strategies = listOf(CdbStrategyImpl(), FundsStrategyImpl())
    for (strategy in strategies) {
        if (strategy.type.value == type)
            return strategy
    }
    throw UnsupportedOperationException("Strategy not found")
}