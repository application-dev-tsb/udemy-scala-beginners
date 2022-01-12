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


  def isPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeTail(t : Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTail(t-1, n%t != 0 && isStillPrime)
    }

    isPrimeTail(n/2, true)
  }

  println(s"Is 1 prime? ${isPrime(1)}")
  println(s"Is 2003 prime? ${isPrime(2003)}")
  println(s"Is 629 prime? ${isPrime(629)}")

  def fibonacci(n: BigInt): BigInt = {

    @tailrec
    def fibTail(i: BigInt, last: BigInt, nextToLast: BigInt): BigInt = {
      if (i >= n) last
      else fibTail(i+1, last+nextToLast, last)
    }

    if (n <=2 ) 1
    else fibTail(2, 1, 1)
  }

  println(fibonacci(1))
  println(fibonacci(5))
  println(fibonacci(10000))
}
