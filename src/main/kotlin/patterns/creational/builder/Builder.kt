class FoodOrder private constructor(
    val bread: String?,
    val condiments: String?,
    val meat: String?,
    val fish: String?) {

    data class Builder(
        var bread: String? = null,
        var condiments: String? = null,
        var meat: String? = null,
        var fish: String? = null) {

        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build() = FoodOrder(bread, condiments, meat, fish)
    }

    override fun toString(): String {
        return "FoodOrder(bread=$bread, condiments=$condiments, meat=$meat, fish=$fish)"
    }
}

fun main() {
    val order = FoodOrder.Builder()
        .bread("wheat")
        .condiments("mayo")
        .meat("chicken")
        .fish("salmon")
        .build()

    println(order.toString())
}