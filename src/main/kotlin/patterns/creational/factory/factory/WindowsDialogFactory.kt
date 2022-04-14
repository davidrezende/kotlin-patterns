package patterns.creational.factory.factory

import patterns.creational.factory.product.Button
import patterns.creational.factory.product.WindowsButton

class WindowsDialogFactory : DialogFactory() {
    override fun createButton(): Button = WindowsButton()
}