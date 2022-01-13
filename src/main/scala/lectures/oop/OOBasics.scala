package lectures.oop

object OOBasics extends App {

  val person = new Person("John Doe", 25)

  println(person.age)
  println(person.nextAge)

  person.greet("Jane Doe")
  person.greet()
}

/**
 * - constructor parameters ARE NOT FIELDS
 * - use "val" to add the getter
 */
class Person(name: String, val age: Int) {
  println("This is a constructor")

  val nextAge = age + 1


  def greet(name: String) = println(s"${this.name}: Hi $name")

  def greet() = println(s"$name: Hi Stranger")
}
