package MyImps

import ViewedInClass.gcd
import ViewedInClass.phiEuler
import java.lang.RuntimeException
import kotlin.math.pow

fun eulerTheorem(a: Int, mod: Int): Boolean {
    if (gcd(a, mod) != 1) throw RuntimeException("a and n must be coprime")
    val power = a.toDouble().pow(phiEuler(mod))
    return power.toInt() % mod == 1 % mod
}

fun smallFermatTheorem(a: Int, mod: Int): Int {
    // assuming mod is prime
    // val power = a.toDouble().pow(mod - 1)
    // return power.toInt() % mod == 1 % mod
    return 1 % mod
}

fun multiplicativeInverse(a: Int, mod: Int): Int {
    return a.toDouble().pow(mod - 2).toInt()
}

fun orderOf(a: Int, mod: Int): Int {
    for (i in 1 until mod) {
        val powerMod = a.toBigInteger().modPow(i.toBigInteger(), mod.toBigInteger())
        if (powerMod == 1.toBigInteger()) return i
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
    println(2.toBigInteger().modPow(9.toBigInteger(), 13.toBigInteger()))
}