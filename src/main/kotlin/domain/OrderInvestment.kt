package domain

import java.math.BigDecimal
import java.util.*

data class Order(
    val id: UUID,
    val name: ProductInvestment,
    val value: BigDecimal
)

enum class ProductInvestment(val value: String){
    CDB("CDB"),
    FUNDS("FUNDS")
}