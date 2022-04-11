package patterns.structural.facade

import domain.Order
import domain.ProductInvestment
import domain.StatusInvestment
import domain.fixture.FixtureInvestment

interface OrderService {
    fun sendToProcess(order: Order): Order
}

class CdbOrderService : OrderService {
    override fun sendToProcess(order: Order): Order {
        order.status = StatusInvestment.PROCESSING
        println("Sending productType=${order.name} orderId=${order.id} to process and change status to ${order.status}")
        return order
    }
}

class FundsOrderService : OrderService {
    override fun sendToProcess(order: Order): Order {
        order.status = StatusInvestment.PROCESSING
        println("Sending productType=${order.name} orderId=${order.id} to process and change status to ${order.status}")
        return order
    }
}

class NotificationCustomer {
    fun notifyOrderToCustomer(order: Order, status: StatusInvestment) {
        println("Sending notification to customer=${order.customerId} about your order status change to $status")
    }
}

//Facade
class InvestmentProcessorManager(
    private val cdbService: CdbOrderService = CdbOrderService(),
    private val fundsService: FundsOrderService = FundsOrderService(),
    private val notification: NotificationCustomer = NotificationCustomer()
) {

    fun execute(order: Order) {
        when(order.name){
            ProductInvestment.CDB -> cdbService.sendToProcess(order)
            ProductInvestment.FUNDS -> fundsService.sendToProcess(order)
            else -> {
                throw Exception("Processor not found for this product type")
            }
        }
        notification.notifyOrderToCustomer(order, StatusInvestment.PROCESSING)
    }
}

fun main() {
    val orderInput = FixtureInvestment.random()
    val processor = InvestmentProcessorManager()

    processor.execute(orderInput)
}