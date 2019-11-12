package MyImps

import Exam.bigInt
import java.math.BigInteger
import java.util.*

fun fermatTest(n: BigInteger, k: Int): Boolean {
    val rand = Random()
    val mod = 1.bigInt() % n
    for (i in 0..k) {
        var a: BigInteger
        do {
            a = BigInteger(n.bitLength(), rand)
        }
        while(a < 2.bigInt() || a > n-1.bigInt())

        val power = a.modPow(n - 1.bigInt(), n)
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