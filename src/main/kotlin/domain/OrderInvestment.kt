package domain

import java.math.BigDecimal
import java.util.*

data class Order(
    val id: UUID,
    val name: ProductInvestment,
    val customerId: UUID = UUID.randomUUID(),
    var status: StatusInvestment? = null,
    val value: BigDecimal
)

enum class ProductInvestment(val value: String) {
    CDB("CDB"),
    FUNDS("FUNDS")
}

enum class StatusInvestment(val value: String) {
    SAVED("SAVED"),
    PROCESSING("PROCESSING"),
    PROCESSED("PROCESSED")
}