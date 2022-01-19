package lectures.functional

object PatternMatchingEverything extends App {

  //CONSTANTS
  val x: Any = "Scala"
  def constants(x: Any) = x match {
    case 42 => "This is the best number"
    case "Scala" => "Best Language Ever"
    case PatternMatchingEverything => "Any singleton"
    case _ => "Unmatched"
  }

  println(constants(1))
  println(constants(42))
  println(constants("Scala"))
  println(constants(this))

  //TUPLES
  val myTuple = (0, 1, "Math")

  def tupleMatcher(anything: Any): String = anything match {
    case (a: Int, b: Int, str: String) => s"Awesome tuple: ($a,$b,$str)"
    case any: Any => s"Fallback: $any"
  }

  println(tupleMatcher(this))
  println(tupleMatcher((1, 2, "Hello")))
  println(tupleMatcher((1, 2.5, "Hello")))
}
