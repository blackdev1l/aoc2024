import kotlin.math.abs

class Day2 : Day(2) {

    override fun Part1(input: String) {
        val lines = input.split("\r\n|\n".toRegex())
        val unsafe = lines.map { l ->
            val diffs = l.split(" ")
                .windowed(2)
                .map { it.first().toInt() - it.last().toInt() }
                .toList()
            val isDecreasing = diffs[0] < 0
             diffs.filterNot { it != 0 && abs(it) in 1..3 && isDecreasing == it < 0 }
                .any()
        }.count { it }


        println(lines.size - unsafe)



    }


    override fun Part2(input: String) {
        val lines = input.split("\r\n|\n".toRegex())
        val unsafe = lines.map { l ->
            val diffs = l.split(" ")
                .windowed(2)
                .map { it.first().toInt() - it.last().toInt() }
                .toList()
            val isDecreasing = diffs[0] < 0
            diffs.filterNot { it != 0 && abs(it) in 1..4 && isDecreasing == it < 0 }
                .filterNot { it != 0 && abs(it-1) in 1..4 && isDecreasing == it-1 < 0 }
                .filterNot { it != 0 && abs(it+1) in 1..4 && isDecreasing == it+1 < 0 }
                .any()
        }.count { it }


        println(lines.size - unsafe)
    }

    override fun GetExample(): String {
        return """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
        """.trimIndent()
    }

}

fun main() {
    val day = Day2()
    day.solveDay()
}