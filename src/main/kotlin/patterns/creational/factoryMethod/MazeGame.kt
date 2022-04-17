package patterns.creational.factoryMethod

/**
 * Product
 * -> room Interface
 * -> MagicRoom ConcreteRoom
 *
 * Factory
 * -> MazeFactory Interface
 * -> MagicMazeFactory ConcreteMazeFactory
 */

interface Room {
    fun enter()
}

class MagicRoom : Room {
    override fun enter() {
        println("enter magic room")
    }
}

abstract class MazeFactory {
    abstract fun makeRoom(): Room
}

class MagicMazeFactory : MazeFactory() {
    override fun makeRoom(): Room {
        return MagicRoom()
    }
}

fun main(){
    val mazeFactory = MagicMazeFactory()
    val room = mazeFactory.makeRoom()
    room.enter()
}