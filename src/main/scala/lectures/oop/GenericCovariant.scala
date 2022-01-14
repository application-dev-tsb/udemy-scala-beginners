package lectures.oop

object GenericCovariant extends App {

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //COVARIANT GENERIC TYPE
  //the easiest one, you are guaranteed the type is what you declared
  class MyContainer[+T] {

    var item: Option[B >: T]

    def set[B >: T](item: B): Unit = {
      this.item = Some(item)
    }

    def get(): Option[T] = {
      this.item
    }

    override def toString: String = s"Item = $item"
  }

  val dog = new Dog
  val cat = new Cat

  val container: MyContainer[Animal] = new MyContainer[Dog]
  container.set(dog)
  container.set(cat)

  val content: Option[Animal] = container.get()
}
