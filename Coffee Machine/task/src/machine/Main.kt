package machine

import java.util.*
import kotlin.system.exitProcess

fun main() {
    startCoffeeMachine()
}

fun getCommandForCoffeeMachine(): String {
    val scanner = Scanner(System.`in`)
    return scanner.nextLine().trim()
}

enum class UserActions {
    BUY,
    FILL,
    TAKE,
    REMAINING,
    EXIT
}

class CoffeeMachine(
        private var amountMoneyInDollars: Int = 550,
        private var amountWaterInMl: Int = 400,
        private var amountMilkInMl: Int = 540,
        private var amountCoffeeBeansInGr: Int = 120,
        private var amountDisposableCups: Int = 9
) {

    companion object MachineWorking {
        var conditionMachine = true
        private val coffeeMachine = CoffeeMachine()

        fun command(command: String) {

            if (conditionMachine) {
                when {
                    command.toUpperCase() == UserActions.BUY.name -> {
                        conditionMachine = false
                        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                        executeNextCommand()
                    }
                    command.toUpperCase() == UserActions.FILL.name -> {
                        coffeeMachine.fillMachine()
                        askAboutUserActions()
                        executeNextCommand()
                    }
                    command.toUpperCase() == UserActions.TAKE.name -> {
                        println("I gave you ${coffeeMachine.amountMoneyInDollars}")
                        coffeeMachine.amountMoneyInDollars = 0
                        askAboutUserActions()
                        executeNextCommand()
                    }
                    command.toUpperCase() == UserActions.REMAINING.name -> {
                        coffeeMachine.showHowMuchCoffeeIsAvailable()
                        askAboutUserActions()
                        executeNextCommand()
                    }
                    command.toUpperCase() == UserActions.EXIT.name -> {
                        exitProcess(0)
                    }

                }
            }

            if (!conditionMachine) {
                when (command) {
                    "1" -> {
                        coffeeMachine.makeCoffeeEspresso(250, 16, coffeeMachine.amountDisposableCups, 4)
                        askAboutUserActions()
                        conditionMachine = true
                        executeNextCommand()
                    }
                    "2" -> {
                        coffeeMachine.makeCoffeeLatte(350, 75, 20, coffeeMachine.amountDisposableCups, 7)
                        askAboutUserActions()
                        conditionMachine = true
                        executeNextCommand()
                    }
                    "3" -> {
                        coffeeMachine.makeCoffeeCappuccino(200, 100, 12, coffeeMachine.amountDisposableCups, 6)
                        askAboutUserActions()
                        conditionMachine = true
                        executeNextCommand()
                    }
                    "back" -> {
                        askAboutUserActions()
                        conditionMachine = true
                        executeNextCommand()
                    }
                    else -> {
                        print("Please make the right choice!\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                        executeNextCommand()
                    }
                }
            }
        }
    }

    fun fillMachine() {
        println("Write how many ml of water do you want to add:")
        val strAmountWater = getCommandForCoffeeMachine()
        amountWaterInMl += strAmountWater.toInt()
        println("Write how many ml of milk do you want to add:")
        val strAmountMilk = getCommandForCoffeeMachine()
        amountMilkInMl += strAmountMilk.toInt()
        println("Write how many grams of coffee beans do you want to add:")
        val strAmountCoffeeBeans = getCommandForCoffeeMachine()
        amountCoffeeBeansInGr += strAmountCoffeeBeans.toInt()
        println("Write how many disposable cups of coffee do you want to add:")
        val strAmountDisposableCups = getCommandForCoffeeMachine()
        amountDisposableCups += strAmountDisposableCups.toInt()
    }

    fun showHowMuchCoffeeIsAvailable() {
        println("The coffee machine has:\n$amountWaterInMl of water\n$amountMilkInMl of milk\n$amountCoffeeBeansInGr of coffee beans\n$amountDisposableCups of disposable cups\n$amountMoneyInDollars of money")
    }

    private fun makeCoffeeEspresso(water: Int, coffeeBeans: Int, disposableCups: Int, cost: Int) {
        availabilityOfCoffee(water, 0, coffeeBeans, disposableCups)
        amountWaterInMl -= water
        amountCoffeeBeansInGr -= coffeeBeans
        amountDisposableCups -= 1
        amountMoneyInDollars += cost
    }

    fun makeCoffeeLatte(water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int, cost: Int) {
        availabilityOfCoffee(water, milk, coffeeBeans, disposableCups)
        amountWaterInMl -= water
        amountMilkInMl -= milk
        amountCoffeeBeansInGr -= coffeeBeans
        amountDisposableCups -= 1
        amountMoneyInDollars += cost
    }

    fun makeCoffeeCappuccino(water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int, cost: Int) {
        availabilityOfCoffee(water, milk, coffeeBeans, disposableCups)
        amountWaterInMl -= water
        amountMilkInMl -= milk
        amountCoffeeBeansInGr -= coffeeBeans
        amountDisposableCups -= 1
        amountMoneyInDollars += cost
    }

    private fun availabilityOfCoffee(water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int) {
        if (water > amountWaterInMl || milk > amountMilkInMl
                || coffeeBeans > amountCoffeeBeansInGr
                || disposableCups > amountDisposableCups
        ) {
            println("Sorry, not enough water!")
            conditionMachine = true
            askAboutUserActions()
            executeNextCommand()
        } else {
            println("I have enough resources, making you a coffee!")
        }
    }
}

fun startCoffeeMachine() {
    askAboutUserActions()
    executeNextCommand()
}

fun askAboutUserActions() {
    println("Write action (buy, fill, take, remaining, exit):")
}

fun executeNextCommand() {
    val command = getCommandForCoffeeMachine()
    CoffeeMachine.command(command)
}