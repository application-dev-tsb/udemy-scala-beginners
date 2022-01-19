package lectures.functional

import scala.util.Random

object PatternMatching extends App {

  val rand = new Random
  val x = rand.nextInt(10)

  val description = x match {
    case 1 => "The One"
    case 2 => "double whammy!"
    case _ => "Default thing"
  }

  println(s"$x : $description")
}
