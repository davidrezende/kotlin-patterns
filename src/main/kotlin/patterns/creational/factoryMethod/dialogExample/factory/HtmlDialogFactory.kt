package patterns.creational.factoryMethod.dialogExample.factory

import patterns.creational.factoryMethod.dialogExample.product.Button
import patterns.creational.factoryMethod.dialogExample.product.HtmlButton

class HtmlDialogFactory : DialogFactory() {
    override fun createButton(): Button = HtmlButton()
}