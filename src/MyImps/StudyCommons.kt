package MyImps

import Exam.bigInt
import ViewedInClass.gcd
import ViewedInClass.phiEuler
import java.lang.RuntimeException
import java.math.BigInteger
import kotlin.math.pow

// if a and n co-prime
fun eulerTheorem(a: Int, mod: Int): Boolean {
    if (gcd(a, mod) != 1) throw RuntimeException("a and n must be coprime") as Throwable
    val power = a.toDouble().pow(phiEuler(mod))
    return power.toInt() % mod == 1 % mod
}

// if a and p are integers and p is prime
fun smallFermatTheorem(a: Int, p: Int): Boolean {
    val power = a.toDouble().pow(p - 1)
    return power.toInt() % p == 1 % p
}

// not sure if conditions from
// previous theorems must be met
fun multiplicativeInverse(a: Int, p: Int): Int {
    return a.toDouble().pow(p - 2).toInt()
}

fun orderOf(a: Int, mod: Int): Int {
    for (i in 1 until mod) {
        val powerMod = a.bigInt().modPow(i.bigInt(), mod.bigInt())
        if (powerMod == 1.bigInt()) return i
    }
    return mod - 1
}

fun primitivesIn(mod: Int): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 2 until mod) {
        if (orderOf(i, mod) == mod - 1) list.add(i)
    }
    return list
}

fun numOfPrimitivesIn(size: Int): Int {
    return phiEuler(size-1)
}

fun main() {
    println(eulerTheorem(5, 7))
    println(smallFermatTheorem(5, 7))

    println()
    println(orderOf(2, 7))
    println(primitivesIn(7))
    println(numOfPrimitivesIn(7))

    println("----------")

    // Int to Hex
    println(BigInteger("123").toString(16))

    // 45 from a binary input
    println(BigInteger("101101", 2))
}