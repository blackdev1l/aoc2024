class Day3 : Day(3) {
    override fun Part1(input: String) {
        val res = solution(input)

        println(res)
    }

    private fun solution(input: String) = "mul\\(\\d+,\\d+\\)"
        .toRegex()
        .findAll(input)
        .map { it.value }
        .map { match -> "\\d+".toRegex().findAll(match).map { it.value.toInt() }.reduce { acc, i -> acc * i } }
        .sum()

    override fun Part2(input: String) {
        val res = "do+".toRegex().split(input)
            .filterNot { it.startsWith("n't") }
            .map { solution(it) }
            .sum()

        println(res)
    }

    override fun GetExample(): String {
        return "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
    }
}

fun main() {

    val day = Day3()
    day.solveDay()

}