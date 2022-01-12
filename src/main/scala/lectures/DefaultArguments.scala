package lectures

object DefaultArguments extends App {

  def someFunc(age: Int = 25, name: String = "John Doe", isMale: Boolean = true) = {
    println(s"Hi Im $name ($age) - Male? $isMale")
  }

  someFunc()
  someFunc(26, "Juan dela Cruz")
  someFunc(isMale = false)
}
