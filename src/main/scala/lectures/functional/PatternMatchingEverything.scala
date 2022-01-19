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
}
