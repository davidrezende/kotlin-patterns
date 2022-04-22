package patterns.structural.adapter

internal interface Bird {
    fun fly()
    fun makeSound()
}

//Pardal
internal class Sparrow : Bird {
    override fun fly() {
        println("Flying")
    }

    override fun makeSound() {
        println("Chirp Chirp")
    }
}

internal interface ToyDuck {
    // interface alvo
    // pato de brinquedo não voa, ele apenas faz um som
    fun squeak()
}

internal class PlasticToyDuck : ToyDuck {
    override fun squeak() {
        println("Squeak")
    }
}

//Cliente espera que um Pato de brinquedo emita um som de um pássaro
//Vamos adaptar o pássaro para a interface do Pato de brinquedo
//Alteramos o som do pato de brinquedo para o do passáro
internal class BirdAdapter(var bird: Bird) : ToyDuck {
    override fun squeak() {
        bird.makeSound()
    }
}

fun main() {

    val sparrow = Sparrow()

    println("Sparrow...")
    sparrow.fly()
    sparrow.makeSound()

    println("ToyDuck...")
    val toyDuck =  PlasticToyDuck()
    toyDuck.squeak()

    println("BirdAdapter...")
    // Envolve um pássaro em um birdAdapter para que ele
    // se comporta como pato de brinquedo
    val birdAdapter = BirdAdapter(sparrow)
    birdAdapter.squeak()
}