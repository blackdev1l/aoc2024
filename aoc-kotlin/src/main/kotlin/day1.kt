import kotlin.math.abs

val example = """3   4
4   3
2   5
1   3
3   9
3   3"""


fun splitInput(input: String): List<String> {
    return input.split("\r\n|\n".toRegex())
}

fun toPair(input: List<String>): Pair<ArrayList<Int>, ArrayList<Int>> {

    val left = ArrayList<Int>()
    val right = ArrayList<Int>()

    for (s in input) {
        val splitted = s.split("\\s+".toRegex())

        left.add(splitted.first().toInt())
        right.add(splitted.last().toInt())
    }
    left.sort()
    right.sort()
    return Pair(left, right)
}

fun findDistance(pair: Pair<ArrayList<Int>, ArrayList<Int>>): Int {

    var res = 0
    for (i in 0..<pair.first.size) {
        res += abs(pair.first[i] - pair.second[i])

    }

    return res

}

fun solvePart1(input: String) {
    val res = findDistance(toPair(splitInput(input)))
    println(res)
}

fun getOccurrences(list: ArrayList<Int>): Map<Int, Int> {
    return list.groupingBy { it }.eachCount()
}

fun calculateOccurrences(list: ArrayList<Int>, occ: Map<Int, Int>): Int {
    return list.sumOf { it * occ.getOrDefault(it, 0) }
}

fun solvePart2(input: String) {
    val pair = toPair(splitInput(input))
    val occ = getOccurrences(pair.second)
    val res = calculateOccurrences(pair.first, occ)
    println(res)
}


fun main() {
    val input = object {}.javaClass.getResourceAsStream("day1.txt")?.bufferedReader()?.readText()
    solvePart1(input!!)
    solvePart2(input)


}