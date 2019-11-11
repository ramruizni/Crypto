package MyImps

import java.math.BigInteger
import java.util.*

fun fermatTest(n: BigInteger, k: Int): Boolean {
    val rand = Random()
    val mod = 1.toBigInteger() % n
    for (i in 0..k) {
        var a: BigInteger
        do {
            a = BigInteger(n.bitLength(), rand)
        }
        while(a < 2.toBigInteger() || a > n-1.toBigInteger())

        val power = a.modPow(n - 1.toBigInteger(), n)
        if (power != mod) {
            println("a: $a")
            println("mod: $mod")
            println("powerMod: $power")
            return false
        }
    }
    return true
}

fun main() {
    println(fermatTest(14.toBigInteger(), 20))
    //println(4.toBigInteger().pow(99) % 100.toBigInteger())
    //println(1 % 100)
}