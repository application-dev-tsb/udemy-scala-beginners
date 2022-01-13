package lectures.oop

object ApplyMethod extends App {

  class RunnableThing {

    def apply() = println("Run!")

    def apply(software: String) = println(s"Run: $software!")
  }

  var softwareRunner = new RunnableThing

  /**
   * "apply" is a special method name in scala that lets you write some shortcuts
   * like this:
   */
  softwareRunner()
  softwareRunner("JVM")
}
