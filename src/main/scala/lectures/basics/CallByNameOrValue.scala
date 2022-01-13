package lectures.basics

import scala.util.Random

object CallByNameOrValue extends App {

  def callByValue(myValue: Int) = {
    println(s"Call By Value: $myValue")
    println(s"Call By Value: $myValue")
  }

  def callByName(supplier: => Int) = {
    println(s"Call By Name: $supplier")
    println(s"Call By Name: $supplier")
  }

  callByValue(Random.nextInt())
  callByName(Random.nextInt())
}
