package ViewedInClass

import java.math.BigInteger

val bigTwo   = BigInteger.valueOf(2L)
val bigThree = BigInteger.valueOf(3L)

fun main() {
    println("With sieve: ${sieve(100)}")
    print("With MilRa: [")
    print("2, ")
    val k = 20
    for (i in 3..99 step 2)
        if (isProbablyPrime(BigInteger.valueOf(i.toLong()), k)) {
            print("$i, ")
        }
    println("]\n")
}