import kotlin.random.Random

fun main(){
    println("Enter a number of philosophers")
    val countPhilosophers = enteringCountNum()

    val philosophers = ArrayList<Philosopher>()
    val forks = ArrayList<Fork>()

    for (i in 0..< countPhilosophers){
        forks.add(Fork())
    }

    for (i in 0..< countPhilosophers) {
        print("Enter name of philosopher ${i + 1} - ")
        var namePhilosopher = readln()
        if (namePhilosopher.trim() == ""){
            namePhilosopher = "${i + 1}"
        }
        philosophers.add(Philosopher(namePhilosopher, rightFork = forks[i], leftFork = forks[(i + 1) % countPhilosophers]))
    }

    val busyPhilosopher = ArrayList<Philosopher>()

    while (busyPhilosopher.size != countPhilosophers) {
        val philosopher = philosophers[Random.nextInt(0,countPhilosophers)]
        if (philosopher.isBusy) continue

        philosopher.tryEat()
        busyPhilosopher.add(philosopher)
    }

}

fun enteringCountNum(): Int {
    try {
        val number = readln().toInt()
        if (number <= 1){
            println("Philosophers must be more then 1, set default value - 2")
            return 2
        }
        return number
    }
    catch (e : Exception){
        println("Invalid input data, must be a number, set default value - 2")
        return 2
    }
}
