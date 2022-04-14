package patterns.creational.factory

interface Virus {
    fun mutate()
    fun spread() {
        println("Spreading the virus...")
    }
}

class CoronaVirus: Virus {
    override fun mutate() {
        println("Mutating the corona virus...")
    }
}

class InfluenzaVirus: Virus {
    override fun mutate() {
        println("Mutating the flu virus...")
    }
}

class HIVVirus: Virus {
    override fun mutate() {
        println("Mutating the HIV virus...")
    }
}

enum class VirusType {
    CORONA_VIRUS, INFLUENZA, HIV
}

class VirusFactory {
    fun makeVirus(type: VirusType): Virus? {
        return when(type) {
            VirusType.CORONA_VIRUS -> CoronaVirus()
            VirusType.INFLUENZA -> InfluenzaVirus()
            VirusType.HIV -> HIVVirus()
            else -> null
        }
    }
}

fun main() {
    val factory = VirusFactory()
    val virus = factory.makeVirus(VirusType.CORONA_VIRUS)
    virus?.spread()
    virus?.mutate()
}

