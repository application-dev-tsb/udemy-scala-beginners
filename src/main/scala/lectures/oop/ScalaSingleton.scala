package lectures.oop

object ScalaSingleton extends App {

  object Person {
    val DEFAULT_AGE = 10
    def apply(name: String) = new Person(name)
    def apply(name: String, age: Int) = new Person(name, age)
  }

  class Person(name: String, age: Int = Person.DEFAULT_AGE) {
    override def toString: String = s"Person($name, $age)"
    def hasDefaultAge = age == Person.DEFAULT_AGE
  }


  var joe = Person("Joe")
  var john = Person("John", 20)

  println(joe)
  println(joe.hasDefaultAge)
  println(john.hasDefaultAge)
}
