package lectures.oop

import scala.language.postfixOps //required for postfix ops

object PrePostInfixMethods extends App {


  class Person(val name: String, val favoriteLanguage: String, age: Int = 25) {

    /**
     * unary operators: - ~ ! +
     */
    def unary_! = s"$favoriteLanguage is so Awesome"

    def unary_+ = new Person(name, favoriteLanguage, age+1)

    def likesTheSameLanguageAs(otherPerson: Person): Boolean = favoriteLanguage == otherPerson.favoriteLanguage

    /**
     * scala is a bit liberal with method names
     */
    def +(otherPerson: Person): Person = new Person(s"${this.name}, ${otherPerson.name}", this.favoriteLanguage)

    def isModern: Boolean = favoriteLanguage == "Scala"

    override def toString: String = s"Person($name, $favoriteLanguage, $age)"
  }

  val james = new Person("James Gosling", "Java")
  val steve = new Person("Steve Jobs", "ObjectiveC")

  println(!steve)

  /**
   * we can skip the "." and use a more expressive syntax
   * this only works when theres just one parameter
   */
  println(james likesTheSameLanguageAs steve)
  println(james + steve)

  /**
   * not that cool but still possible: postfix
   */
  println(steve isModern)

  println(steve)
  println(+steve)
}