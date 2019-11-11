package Exam

import MyImps.primitivesIn
import java.math.BigInteger
import java.security.SecureRandom

fun main() {
    val rand = SecureRandom()

    val p = 2579
    val alpha = primitivesIn(2579).random()
    val x = rand.nextInt(p - 3) + 1

    val beta = alpha.modPow(x, p)

    println("Ke ($p, $alpha, $beta)") // public key
    println("X $x")

    val msg = 1299

    val y = (rand.nextInt(p - 3) + 1)

    val gamma = alpha.modPow(y, p)
    val delta = (msg * beta.modPow(y, p)) % p

    println("C ($gamma, $delta)")

    val pPrime = p - 1 - x
    val dec = (delta * gamma.modPow(pPrime, p)) % p
    println(dec)
}

fun Int.bigInt(): BigInteger {
    return BigInteger(this.toString())
}

fun String.bigInt(): BigInteger {
    return BigInteger(this)
}

fun Int.modPow(e: Int, m: Int): Int {
    return this.bigInt().modPow(e.bigInt(), m.bigInt()).toInt()
}