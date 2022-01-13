package lectures.oop

object Inheritance extends App {

  class Animal {
    def eat = println("nyam nyam nyam")
  }

  class Cat extends Animal {
  }

  val cat = new Cat
  cat.eat

  sealed abstract class Robot(val name: String, val powerLevel: Int) {
    def attack(): Unit

    final def robotTalk() = println(s"$name: Talk Robotiiiikkk")

    override def toString: String = s"Robot($name, $powerLevel)"
  }

  class NinjaBot(name: String, powerLevel: Int) extends Robot(name, powerLevel) {
    override def attack(): Unit = println("Attack! Ninja Style")
  }

  val ninjaBot = new NinjaBot("Ninja 1", 9)

  //FINAL = disallow override/extend
  //SEALED = same with FINAL but allows when defined in the same file

  println(ninjaBot)
}
