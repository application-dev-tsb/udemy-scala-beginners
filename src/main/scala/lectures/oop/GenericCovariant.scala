package lectures.oop

object GenericCovariant extends App {

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //COVARIANT GENERIC TYPE
  //the easiest one, you are guaranteed the type is what you declared
  class StorageMachine[+T] {

    //var item: Option[T] = None

    def store[B >: T](item: B): Unit = ???

    def fetch(): Option[T] = ???

    //override def toString: String = s"Item = $item"
  }

  val dog = new Dog
  val cat = new Cat

  val container: StorageMachine[Animal] = new StorageMachine[Dog]
  container.store(dog)
  container.store(cat)

  val content: Option[Animal] = container.fetch()
}
