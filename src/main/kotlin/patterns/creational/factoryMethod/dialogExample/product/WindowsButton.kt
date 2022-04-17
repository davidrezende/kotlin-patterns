package patterns.creational.factoryMethod.dialogExample.product

class WindowsButton : Button {
    override fun render() {
        println("Rendering Windows button")
    }

    override fun onClick() {
        println("Clicking Windows button")
    }

}