import kotlin.random.Random

fun main(args: Array<String>) {
    var numGuess = NumberGuess()
    println(numGuess.game())
}

class NumberGuess {
    var rangeStart: Int = 0
    var rangeEnd: Int = 100
    var numberPickedByProgram : Int = Random.nextInt(rangeStart, rangeEnd)

    fun game(){
        var numberGuessedCorrectly: Boolean = false
        print("Write any number between $rangeStart and $rangeEnd: ")
        var numberGuessedByUser = Integer.valueOf(readLine())
        var output = if(numberGuessedByUser == numberPickedByProgram) {
            numberGuessedCorrectly = true
            "Correct!"
        }else if (numberGuessedByUser < rangeStart || numberGuessedByUser > rangeEnd){
            "That's outside the range!"
        }else if (numberGuessedByUser < numberPickedByProgram){
            "Too small!"
        } else if (numberGuessedByUser > numberPickedByProgram){
            "Too Big!"
        } else {
            "Was your number in the correct range?"
            //what about incorrect format, ints that are too large
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
