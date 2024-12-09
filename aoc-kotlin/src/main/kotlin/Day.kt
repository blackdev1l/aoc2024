abstract class Day constructor(val day: Int) {



    abstract fun Part1(input: String): Unit
    abstract fun Part2(input: String): Unit
    abstract fun GetExample(): String
    fun GetInput(): String {
        val filename = "day${"%d".format(this.day)}.txt"
        return object {}.javaClass.getResourceAsStream(filename)?.bufferedReader()?.readText()!!

    }

    fun solveDay() {
        println("== Day ${"%d".format(day)} ==")
        val input = GetInput()
        Part1(input)
        Part2(input)

    }


}