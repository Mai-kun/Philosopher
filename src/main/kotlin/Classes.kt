import kotlin.random.Random

class Philosopher(private val name: String,
                  private val rightFork : Fork,
                  private val leftFork : Fork,
                  var isBusy : Boolean = false)
{
    fun tryEat() {
        when (Random.nextInt(0,2)){
            0 -> if (!leftFork.isGet){
                println("Philosopher $name is eating (get left fork)")
                leftFork.isGet = true
                return
            }
            else if (!rightFork.isGet){
                println("Philosopher $name is eating (get right fork)")
                rightFork.isGet = true
                return
            }

            1 -> if (!rightFork.isGet){
                println("Philosopher $name is eating (get right fork)")
                rightFork.isGet = true
                return
            }
            else if (!leftFork.isGet){
                println("Philosopher $name is eating (get left fork)")
                leftFork.isGet = true
                return
            }
        }
        println("$name is thinking")
        isBusy = true
    }
}

class Fork(var isGet : Boolean = false)