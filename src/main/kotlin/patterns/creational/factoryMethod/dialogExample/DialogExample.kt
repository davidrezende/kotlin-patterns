package patterns.creational.factoryMethod

import patterns.creational.factoryMethod.dialogExample.factory.DialogFactory
import patterns.creational.factoryMethod.dialogExample.factory.HtmlDialogFactory
import patterns.creational.factoryMethod.dialogExample.factory.WindowsDialogFactory
import patterns.creational.factoryMethod.dialogExample.factory.enum.DialogEnum

//Neste exemplo, os botões desempenham uma função de produto e os dialogs atuam como criadores.
fun main() {
    val dialogFactory : DialogFactory
    val randomDialogType = listOf(DialogEnum.values().toList().random()).random()
    dialogFactory = createDialog(randomDialogType)
    dialogFactory.renderWindow()
}

private fun createDialog(dialogType: DialogEnum): DialogFactory {
    return when (dialogType) {
        DialogEnum.WINDOWS -> WindowsDialogFactory()
        DialogEnum.HTML -> HtmlDialogFactory()
        else -> throw IllegalArgumentException("Unknown dialog type: $dialogType")
    }
}