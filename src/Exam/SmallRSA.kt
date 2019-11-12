package Exam

import java.math.BigInteger
import java.security.SecureRandom

fun main() {
    val rand = SecureRandom()
    val p = 47; val q = 71
    val n = p * q

    val phi = (p - 1) * (q - 1)
    println("phi $phi")

    var e: Int
    do e = rand.nextInt(phi - 2) + 2
    while (e.bigInt().gcd(phi.bigInt()) != 1.bigInt())

    val d = e.bigInt().modInverse(phi.bigInt()).toInt()
    println("Ke ($e, $n)")
    println("Kd ($d, $n)")

    val msg = 688
    println("smallMsg $msg")

    val enc = msg.modPow(e, n)
    println("smallEnc $enc")

    val dec = enc.modPow(d, n)
    println("smallDec $dec")

    val bigMsg = BigInteger("6882326879666683")
    println("bigMsg $bigMsg")

    val bigEnc = encryptByBlocks(bigMsg, e, n)
    println("bigEnc $bigEnc")

    val bigDec = decryptByBlocks(bigEnc, d, n)
    println("bigDec $bigDec")
}

fun encryptByBlocks(msg: BigInteger, e: Int, n: Int): List<Int> {
    val enc = mutableListOf<Int>()
    val msgSplit = msg.toString().chunked(n.toString().length - 1)

    for (it: String in msgSplit) {
        enc.add(it.toInt().modPow(e, n))
    }
    return enc
}

fun decryptByBlocks(enc: List<Int>, d: Int, n: Int): List<Int> {
    val dec = mutableListOf<Int>()

    for (it: Int in enc) {
        dec.add(it.modPow(d, n))
    }
    return dec
}