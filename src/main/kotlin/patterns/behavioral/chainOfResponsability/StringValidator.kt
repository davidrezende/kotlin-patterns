package patterns.behavioral.chainOfResponsability

enum class ClassElementsType(val value: String) {
    DATACLAS("DATACLAS"),
    STORCLASS("STORCLASS")
}

enum class ElementsType(val value: String) {
    UNITY("UNITY"),
}

abstract class ValidatorChain {
    abstract val next: ValidatorChain?
    abstract fun exists(s: String, map: MutableMap<String, String>): MutableMap<String, String>
}

class HandleClasChain(override val next: ValidatorChain?  = null) : ValidatorChain() {

    override fun exists(s: String, map : MutableMap<String, String>): MutableMap<String, String> {
        ClassElementsType.values().forEach { type ->
                s.split(",").forEach {
                    if (it.contains(type.value)) {
                        map[type.value] = it
                    }
                }
        }
        if(next != null) {
            return next.exists(s, map)
        }
        return map
    }
}

class HandleUnityChain(override val next: ValidatorChain? = null) : ValidatorChain() {

    override fun exists(s: String, map : MutableMap<String, String>): MutableMap<String, String> {
        if(s.contains(ElementsType.UNITY.value)){
            val unity = s.split(",*\\),".toRegex()).first().plus(")")
            println("unity:" + unity)
            map[ElementsType.UNITY.value] = unity
        }
        if(next != null) {
            return next.exists(s, map)
        }
        return map
    }
}


fun main() {
    val input = "UNITY=(sysda,3),DATACLAS=xdefault,STORCLASS=extnos3"

    val chainUnity = HandleUnityChain()
    val chainClass = HandleClasChain(chainUnity)
    val map = chainClass.exists(input, mutableMapOf())
    map.forEach {
        println("${it.key} = ${it.value}")
    }
}