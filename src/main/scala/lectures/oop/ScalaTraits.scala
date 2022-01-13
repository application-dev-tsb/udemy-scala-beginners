package lectures.oop

object ScalaTraits extends App {

  trait Killable(val targetId: String) {
    def kill(): Unit = println("gasp!")
  }

  class Person(val name: String) {
  }

  class Merchant(name: String) extends Person(name) with Killable(name) {

  }

  class Assassin extends Person("secret") with Killable("Assassin") {

    def assassinate(target: Killable): Unit = {
      println(s"Killed ${target.targetId}")
      target.kill()
    }
  }

  val assassin = new Assassin()
  val merchant = new Merchant("John")

  assassin.assassinate(merchant)
}
