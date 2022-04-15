package patterns.creational.factory.dialogFactoryExample.factory

import patterns.creational.factory.dialogFactoryExample.product.Button
import patterns.creational.factory.dialogFactoryExample.product.WindowsButton

class WindowsDialogFactory : DialogFactory() {
    override fun createButton(): Button = WindowsButton()
}