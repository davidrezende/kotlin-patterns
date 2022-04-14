package patterns.creational.factory.factory

import patterns.creational.factory.product.Button
import patterns.creational.factory.product.HtmlButton

class HtmlDialogFactory : DialogFactory() {
    override fun createButton(): Button = HtmlButton()
}