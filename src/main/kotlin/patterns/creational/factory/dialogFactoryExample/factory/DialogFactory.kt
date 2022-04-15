package patterns.creational.factory.dialogFactoryExample.factory

import patterns.creational.factory.dialogFactoryExample.product.Button

//Base Factory Class
abstract class DialogFactory {
    fun renderWindow() {
        println("Rendering dialog window")
        //other code
        val okButton : Button = createButton()
        okButton.render()
    }

    //As subclasses substituirão este método para criar um botão específico
    abstract fun createButton(): Button

}