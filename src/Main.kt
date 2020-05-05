// https://www.hackerrank.com/challenges/crush/problem

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    var max = -1L
    var value = 0L
    val additions = Array(size = n, init = { 0L })

    queries.forEach { query ->
        val startIndex = query[0] - 1
        val endIndex = query[1]
        val addition = query[2]

        additions[startIndex] += addition.toLong()

        if (endIndex < n)
            additions[endIndex] -= addition.toLong()
    }

    for (i in 0 until n) {
        value += additions[i]

        if (value > max)
            max = value
    }

    return max
}

fun main() {
    println(
        arrayManipulation(
            10,
            listOf(
                intArrayOf(1, 5, 3).toTypedArray(),
                intArrayOf(4, 8, 7).toTypedArray(),
                intArrayOf(6, 9, 1).toTypedArray()
            ).toTypedArray()
        )
    )
}