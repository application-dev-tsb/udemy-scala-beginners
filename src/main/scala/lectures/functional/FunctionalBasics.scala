package lectures.functional

object FunctionalBasics extends App {

  //higher-order functions
  def nTimes[A](f: (A) => A, n: Int, value: A): A = {
    if (n <= 0) value
    else nTimes(f, n-1, f(value))
  }

  val add3 = (x: Int) => x + 3

  println(nTimes(add3, 1, 3))
  println(nTimes(add3, 10, 3))

}
