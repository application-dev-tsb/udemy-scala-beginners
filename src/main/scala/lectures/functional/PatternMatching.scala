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

  //advance: pattern matching on sealed hierarchies
  sealed class Animal
  case class Dog(bark: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal =
    if (new Random().nextBoolean()) Dog("woof woof")
    else Parrot("Hello Human!")

  val animalGreeting: String = animal match {
    case Dog(b) => s"DOG: $b"
    case Parrot(words) => s"HUMAN VOICE: $words"
    case _ => "Scary unknown animal"
  }

  println(animalGreeting)

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(expr: Expr): String = expr match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParenthesis(expr: Expr) = expr match {
        case Prod(_, _) => show(expr)
        case Number(_) => show(expr)
        case _ => s"( ${show(expr)} )"
      }

      maybeShowParenthesis(e1) + " x " + maybeShowParenthesis(e2)
    }
    case _ => "?"
  }

  println(show(Sum(Number(1), Number(2))))
  println(show(Sum(Number(1), Prod(Number(1), Sum(Number(4), Number(5))))))
}
