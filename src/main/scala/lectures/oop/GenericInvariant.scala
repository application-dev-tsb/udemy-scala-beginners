package lectures.oop

import java.util

object GenericInvariant extends App {

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //INVARIANT GENERIC TYPE
  //the easiest one, you are guaranteed the type is what you declared
  class MyContainer[T] {

    var item: Option[T] = Option.empty[T]

    def set(item: T): Unit = {
      this.item = Some(item)
    }

    def get(): Option[T] = {
      this.item
    }

    override def toString: String = s"Item = $item"
  }

  val dog = new Dog
  val cat = new Cat

  val container = new MyContainer[Animal]
  container.set(dog)
  container.set(cat)

  val content: Option[Animal] = container.get()

  println(container)
  println(content)

}
