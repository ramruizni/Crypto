package Exam

import java.math.BigInteger
import java.security.SecureRandom

fun main() {
    val rand = SecureRandom()

    val p = BigInteger.probablePrime(BIT_LENGTH_2048, rand)
    val alpha = 2.bigInt()

    var x: BigInteger
    do {
        x = BigInteger(BIT_LENGTH_2048, rand)
    } while (x >= (p - 3.bigInt()) || x < 1.bigInt())

    val beta = alpha.modPow(x, p)
    println("Ke ($p, $alpha, $beta)") // public key
    println("X $x")

    val msg = "12345678909876543211234567890987654321123456789098765432112345678909876543211234567890987654321".bigInt()

    var y: BigInteger
    do {
        y = BigInteger(BIT_LENGTH_2048, rand)
    } while (y >= (p - 3.bigInt()) || y < 1.bigInt())

    val gamma = alpha.modPow(y, p)
    val delta = (msg * beta.modPow(y, p)) % p
    println("C ($gamma, $delta)")

    val pPrime = p - 1.bigInt() - x
    val dec = (delta * gamma.modPow(pPrime, p)) % p
    println(dec)
}