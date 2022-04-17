package patterns.creational.factoryMethod.dialogExample.factory

import patterns.creational.factoryMethod.dialogExample.product.Button
import patterns.creational.factoryMethod.dialogExample.product.WindowsButton

class WindowsDialogFactory : DialogFactory() {
    override fun createButton(): Button = WindowsButton()
}