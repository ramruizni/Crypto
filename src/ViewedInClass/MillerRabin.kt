package ViewedInClass

import java.math.BigInteger
import java.util.Random

val bigTwo   = BigInteger.valueOf(2L)
val bigThree = BigInteger.valueOf(3L)

fun isProbablyPrime(n: BigInteger, k: Int): Boolean {
    require (n > bigTwo && n % bigTwo == BigInteger.ONE) { "Must be odd and greater than 2" }
    var s = 0
    val nn = n - BigInteger.ONE
    var d: BigInteger
    do {
        s++
        d = nn.shiftRight(s)
    }
    while (d % bigTwo == BigInteger.ZERO)

    val rand = Random()
    loop@ for (i in 1..k) {
        var a: BigInteger
        do {
            a = BigInteger(n.bitLength(), rand)
        }
        while(a < bigTwo || a > nn) // make sure it's in the interval [2, n - 1]

        //println("Starting point: s=$s, a=$a, d=$d, n=$n")

        var x = a.modPow(d, n)
        if (x == BigInteger.ONE || x == nn) continue
        for (r in 1 until s) {
            x =  (x * x) % n
            if (x == BigInteger.ONE) {
                //println("Got here! $x $a $d $n")
                return false
            }
            if (x == nn) break@loop
        }
        //println("Actually got here! $x $a $d $n")
        return false
    }
    return true
}

fun main() {
    val k = 20 // THIS IS THE ACCURACY
    // obtain all primes up to 100
    println("The following numbers less than 100 are prime:")
    print("2 ")
    for (i in 3..99 step 2)
        if (isProbablyPrime(BigInteger.valueOf(i.toLong()), k)) print("$i ")
    println("\n")
    // check if some big numbers are probably prime
    val bia = arrayOf(
        BigInteger("4547337172376300111955330758342147474062293202868155909489"),
        BigInteger("4547337172376300111955330758342147474062293202868155909393")
    )
    for (bi in bia)
        println("$bi is ${if (isProbablyPrime(bi, k)) "probably prime" else "composite"}")


    println(isProbablyPrime(561.toBigInteger(), 20))

    println(382.toBigInteger().modPow(35.toBigInteger(), 561.toBigInteger()))

}