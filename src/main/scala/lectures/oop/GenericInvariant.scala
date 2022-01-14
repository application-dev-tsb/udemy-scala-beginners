package lectures.oop

import java.util

object GenericInvariant extends App {

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //INVARIANT LIST
  class MyContainer[T] {

    var item: Option[T] = Option.empty[T]

    def set(item: T): Unit = {
      this.item = Option(item)
    }

    def get(): Option[T] = {
      this.item
    }

    override def toString: String = s"Item = $item"
  }

  class EmptyContainer extends MyContainer[Nothing] {
    override def toString: String = "Nothing"
  }



}
