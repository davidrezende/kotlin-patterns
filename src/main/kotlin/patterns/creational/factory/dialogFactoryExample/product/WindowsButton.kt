package patterns.creational.factory.dialogFactoryExample.product

class WindowsButton : Button {
    override fun render() {
        println("Rendering Windows button")
    }

    override fun onClick() {
        println("Clicking Windows button")
    }

}