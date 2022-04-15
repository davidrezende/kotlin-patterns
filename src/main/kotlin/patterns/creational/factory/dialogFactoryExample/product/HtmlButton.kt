package patterns.creational.factory.dialogFactoryExample.product

class HtmlButton : Button {
    override fun render() {
        println("Rendering HTML button")
    }

    override fun onClick() {
        println("Clicking HTML button")
    }
}