package ViewedInClass

import java.math.BigInteger

fun main() {
    val a = BigInteger("2988348162058574136915891421498819466320163312926952423791023078876139")
    val b = BigInteger("2351399303373464486466122544523690094744975233415544072992656881240319")
    val m = BigInteger.TEN.pow(40)
    println(a.modPow(b, m))

    println(7.toBigInteger().modPow(452.toBigInteger(), 31.toBigInteger()))

    println(2019.toBigInteger().modPow(987654321.toBigInteger(), 22.toBigInteger()))
}