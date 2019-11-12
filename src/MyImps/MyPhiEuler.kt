package MyImps

import ViewedInClass.gcd
import ViewedInClass.getPrimeFactors
import ViewedInClass.phiEuler

//Zn
fun intsMod(mod: Int): List<Int> {
    val list = mutableListOf<Int>()
    for(i in 0 until mod) list.add(i)
    return list
}

//Zn*
fun multiplicativeGroupOf(mod: Int): List<Int> {
    val list = mutableListOf<Int>()

    for(i in 0 until mod) {
        if (gcd(i, mod) == 1) list.add(i)
    }
    return list
}

fun slowPhiEuler(mod: Int): Int {
    return multiplicativeGroupOf(mod).size
}

fun midPhiEuler(mod: Int): Int {
    val primeFactors = getPrimeFactors(mod.toBigInteger())
    if (primeFactors.size != 2) return -1
    var product = 1
    for(i in primeFactors) {
        product *= slowPhiEuler(i.toInt())
    }
    return product
}

fun main() {
    println(intsMod(40))
    println(multiplicativeGroupOf(40))
    println(slowPhiEuler(40))
    println(midPhiEuler(40))
    println("It failed because: ")
    println(multiplicativeGroupOf(4))
    println(multiplicativeGroupOf(10               ))
    println(phiEuler(40)) // fast
}
