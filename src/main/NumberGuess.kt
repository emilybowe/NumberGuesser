import kotlin.random.Random

class NumberGuess {
    var numberPickedByProgram : Int = Random.nextInt(0, 100)

    fun game(){
        var numberGuessedCorrectly: Boolean = false
        print("Write any number: ")
        var numberGuessedByUser = Integer.valueOf(readLine())
        var output = if(numberGuessedByUser == numberPickedByProgram) {
            numberGuessedCorrectly = true
            "Correct!"
        }else if (numberGuessedByUser > numberPickedByProgram) {
            "Too Big!"
        }else if (numberGuessedByUser < numberPickedByProgram){
            "Too small!"
        } else {
            "Was that the correct format?"
        }
        println(output)
        println("The entered number is: $numberGuessedByUser")
        println("The correct number is: $numberPickedByProgram")
        promptUser(numberGuessedCorrectly)
    }

    fun promptUser(numberGuessedCorrectly: Boolean) {
        var userWillContinue: String?
        if(numberGuessedCorrectly == true) {
            println("new Game? y/n")
            userWillContinue = readLine()
            if(userWillContinue!!.toLowerCase() == "y") {
                numberPickedByProgram = Random.nextInt(0, 100)
                game()

            }
        }else if(numberGuessedCorrectly == false) {
            println("Try again? y/n")
            userWillContinue = readLine()
            if(userWillContinue!!.toLowerCase() == "y") {
                game()
            }
        }
    }
}

fun main(args: Array<String>) {
    var numGuess = NumberGuess()
    println(numGuess.game())
}