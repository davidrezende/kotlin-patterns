package domain.fixture

import domain.Order
import domain.ProductInvestment
import domain.StatusInvestment
import java.math.BigDecimal
import java.util.*

class FixtureInvestment {
    companion object {
        fun random() = Order(
            id = UUID.randomUUID(),
            name = ProductInvestment.valueOf(listOf("CDB", "FUNDS").random()),
            customerId = UUID.randomUUID(),
            value = BigDecimal.valueOf(1000.00)
        )
    }
}