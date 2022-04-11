package patterns.behavioral.strategy

import domain.Order
import domain.ProductInvestment
import domain.fixture.FixtureInvestment

interface OrderStrategy {
    var type: ProductInvestment
}

interface BuyOrderStrategy : OrderStrategy {
    fun buy(order: Order): Order
}

class CdbBuyStrategyImpl : BuyOrderStrategy {
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

class FundsBuyStrategyImpl() : BuyOrderStrategy {
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
    val randomOrder = FixtureInvestment.random()
    println("Starting with randomOrder: $randomOrder")
    val strategy = choiceStrategy(randomOrder.name.value)
    val result = strategy.buy(randomOrder)
    println("Return value: $result")

}

private fun choiceStrategy(type: String): BuyOrderStrategy {
    val strategies = listOf(CdbBuyStrategyImpl(), FundsBuyStrategyImpl())
    for (strategy in strategies) {
        if (strategy.type.value == type)
            return strategy
    }
    throw UnsupportedOperationException("Strategy not founded")
}