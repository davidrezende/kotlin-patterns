package patterns.structural.adapter

interface Movable {
    val speed: Double
}

class BugattiVeyron : Movable {
    override val speed = 268.0
}

class Ferrari : Movable {
    override val speed = 300.0
}

interface MovableAdapter {
    val speed: Double
}

class MovableAdapterImpl(luxuryCars: Movable? = null) : MovableAdapter {
    override val speed = convertMPHtoKMPH(luxuryCars!!.speed)

    private fun convertMPHtoKMPH(mph: Double): Double {
        return mph * 1.60934
    }
}

fun main() {
    val bugattiVeyron = BugattiVeyron()
    val ferrari = Ferrari()
    //Default speed value in MpH
    println("Bugatti MpH : ${bugattiVeyron.speed}")
    println("Ferrari MpH : ${ferrari.speed}")
    //New speed value convert in KMpH
    println("Bugatti KMpH : ${MovableAdapterImpl(bugattiVeyron).speed}")
    println("Ferrari KMpH : ${MovableAdapterImpl(ferrari).speed}")
}