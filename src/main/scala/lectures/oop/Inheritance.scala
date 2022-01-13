package lectures.oop

object Inheritance extends App {

  class Animal {
    def eat = println("nyam nyam nyam")
  }

  class Cat extends Animal {
  }

  val cat = new Cat
  cat.eat
}
