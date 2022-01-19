package lectures.functional

import scala.util.Random

object PatternMatching extends App {

  val rand = new Random
  val x = rand.nextInt(10)

  //simple example:
  val description = x match {
    case 1 => "The One"
    case 2 => "double whammy!"
    case _ => "Default thing"
  }

  println(s"$x : $description")

  //advanced: pattern matching can extract values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 25)
  val mary = Person("Mary", 18)

  val greeting: String = bob match {
    case Person(n, a) if a < 21 => s"$n is too young"
    case Person(n, a) => s"$n is $a years old"
    case _ => "No Match!" //exception if a case is not matched
  }

  println(greeting)
}
