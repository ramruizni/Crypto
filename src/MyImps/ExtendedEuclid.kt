package MyImps

import kotlin.math.floor

// Finds gcd(a, b) and (x, y) | gcd(a, b) = a*x + b*y
fun extendedEuclid(a: Int, b: Int): List<Int> {
    if (b == 0) {
        return listOf(a, 1, 0)
    }

    val l2 = extendedEuclid(b, a % b)
    val q = floor(a.toDouble() / b.toDouble()).toInt()

    val d = l2[0]; val x = l2[1]; val y = l2[2]

    return listOf(d, y, (x - (q*y)))
}

fun main() {
    println(extendedEuclid(508, 103))
}