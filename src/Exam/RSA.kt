package Exam

import ViewedInClass.isProbablyPrime
import java.math.BigInteger
import java.security.SecureRandom

const val BIT_LENGTH_2048 = 2048
const val BIT_LENGTH_4096 = 4096
const val BIT_LENGTH_8192 = 8192

fun main() {
    val rand = SecureRandom()
    val p = BigInteger.probablePrime(BIT_LENGTH_2048 / 2, rand)
    val q = BigInteger.probablePrime(BIT_LENGTH_2048 / 2, rand)
    println(isProbablyPrime(p, 20))
    println(isProbablyPrime(q, 20))

    val n = p * q

    val phi = (p - 1.bigInt()) * (q - 1.bigInt())
    println("phi $phi")

    var e: BigInteger
    do e = BigInteger(phi.bitLength(), rand)
    while (e <= 1.bigInt() || e >= phi || e.gcd(phi) != 1.bigInt())

    val d = e.modInverse(phi)
    println("Ke ($e, $n)")
    println("Kd ($d, $n)")

    val msg = BigInteger(BIT_LENGTH_2048 / 2, rand)
    println("msg $msg")

    val enc = msg.modPow(e, n)
    println("enc $enc")

    val dec = enc.modPow(d, n)
    println("dec $dec")
}