package lectures.oop

object OOBasics extends App {

  val person = new Person("John Doe", 25)

  println(person.age)
  println(person.nextAge)
}

/**
 * - constructor parameters ARE NOT FIELDS
 * - use "val" to add the getter
 */
class Person(name: String, val age: Int) {
  println("This is a constructor")

  val nextAge = age + 1
}
