package lectures

import scala.annotation.tailrec

object Recursion extends App {

  @tailrec
  def factorial(n: BigInt, accumulator: BigInt = 1): BigInt = {
    if (n <= 1) accumulator
    else factorial(n-1, n * accumulator)
  }

  println(factorial(1))
  println(factorial(2))
  println(factorial(100))
  println(factorial(5000))
}
