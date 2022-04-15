package patterns.creational.factory.dialogFactoryExample.factory

import patterns.creational.factory.dialogFactoryExample.product.Button
import patterns.creational.factory.dialogFactoryExample.product.HtmlButton

class HtmlDialogFactory : DialogFactory() {
    override fun createButton(): Button = HtmlButton()
}