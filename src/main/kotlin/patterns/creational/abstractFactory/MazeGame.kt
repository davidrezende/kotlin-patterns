package patterns.creational.abstractFactory

/**
 * Products
 * -> room Interface
 *  -> MagicRoom ConcreteRoom
 *  -> Arena ConcreteRoom
 *-> monster Interface
 *  -> Mage ConcreteMonster
 *  -> GiantSpider ConcreteMonster
 *
 * Factory Interface
 * -> MazeFactory Interface
 *
 * Concrete Factory
 * -> MagicMazeFactory
 * -> BattleMazeFactory
 */

interface Room {
    fun enter()
}

interface Monster {
    fun show()
}

class MagicRoom : Room {
    override fun enter() {
        println("enter magic room")
    }
}

class Arena : Room {
    override fun enter() {
        println("enter arena room")
    }
}

class Mage : Monster {
    override fun show() {
        println("mage monster appeared")
    }
}

class GiantSpider : Monster {
    override fun show() {
        println("Giant Spider appeared")
    }
}

enum class MazeType(val value: String) {
    MAGIC("MAGIC"),
    BATTLE("BATTLE"),
    OTHER("OTHER")
}


interface MazeFactory {
    fun makeRoom(): Room
    fun makeMonster(): Monster

    companion object {
        fun makeFactory(type: MazeType): MazeFactory {
            return when (type) {
                MazeType.MAGIC -> {
                    MagicMazeFactory()
                }

                MazeType.BATTLE -> {
                    BattleMazeFactory()
                }

                else -> throw IllegalArgumentException("MazeFactory not supported.");
            }
        }
    }
}

class MagicMazeFactory : MazeFactory {
    override fun makeRoom(): Room {
        return MagicRoom()
    }

    override fun makeMonster(): Monster {
        return Mage()
    }
}

class BattleMazeFactory : MazeFactory {
    override fun makeRoom(): Room {
        return Arena()
    }

    override fun makeMonster(): Monster {
        return GiantSpider()
    }
}

fun main() {
    MazeType.values().forEach { type ->
        println("Criando um labirinto do tipo ${type.value}")
        val factory = MazeFactory.makeFactory(type)
        val monster = factory.makeMonster()
        val room = factory.makeRoom()

        room.enter()
        monster.show()
    }

}