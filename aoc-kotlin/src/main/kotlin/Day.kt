abstract class Day {

    abstract fun Part1(input: String): Unit
    abstract fun Part2(input: String): Unit
    abstract fun GetExample(): String
    fun GetInput(day: Int): String {
        val filename = "day${"%d".format(day)}.txt"
        return object {}.javaClass.getResourceAsStream(filename)?.bufferedReader()?.readText()!!

    }

    fun solveDay(day: Int) {
        println("== Day ${"%d".format(day)} ==")
        val input = GetInput(day)
        Part1(input)
        Part2(input)

    }


}