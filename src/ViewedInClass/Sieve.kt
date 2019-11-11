package ViewedInClass

import kotlin.math.sqrt

fun sieve(limit: Int): List<Int> {
    val primes = mutableListOf<Int>()

    if (limit >= 2) {
        val numbers = Array(limit + 1) { true }
        val sqrtLimit = sqrt(limit.toDouble()).toInt()

        for (factor in 2..sqrtLimit) {
            if (numbers[factor]) {
                for (multiple in (factor * factor)..limit step factor) {
                    numbers[multiple] = false
                }
            }
        }

        numbers.forEachIndexed { number, isPrime ->
            if (number >= 2) {
                if (isPrime) {
                    primes.add(number)
                }
            }
        }
    }

    return primes
}

fun main() {
    val n = 100
    val primes = sieve(n)
    println(primes)
    println("Primes up to $n = ${primes.size}")
}