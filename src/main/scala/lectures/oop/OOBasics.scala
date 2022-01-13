package lectures.oop

object OOBasics extends App {

  val person = new Person("John Doe", 25)

  println(person.age)
  println(person.nextAge)

  person.greet("Jane Doe")
  person.greet()

  val person2 = new Person(100)
  println(person2)

  val person3 = new Person()
  println(person3)
}

/**
 * - constructor parameters ARE NOT FIELDS
 * - use "val" to add the getter
 */
class Person(name: String, val age: Int) {
  println("This is a constructor")

  val nextAge: Int = age + 1

  def this() = this("John Doe", 30)

  def this(age: Int) = this("John Doe", age)

  def greet(name: String) = println(s"${this.name}: Hi $name")

  def greet() = println(s"$name: Hi Stranger")

  override def toString: String = s"$name ($age)"
}
