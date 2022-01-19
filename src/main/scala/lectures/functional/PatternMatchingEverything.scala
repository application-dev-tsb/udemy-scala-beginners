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

  //IT CAN ALSO BE NESTED
  val coolNestedTuple = (1, 2, ("Scala", "Awesome"))

  def nestedMatcher(any: Any): String = any match {
    case (a: Int, b: Int) => "Not Cool"
    case (a: Int, b: Int, (_: String, c: String)) => s"Cool: $a, $b, $c"
    case _ => "Also not cool"
  }

  println(nestedMatcher(coolNestedTuple))
  println(nestedMatcher(this))

  //LISTS CAN ALSO BE PATTERN MATCHED
  def listChecker(someList: List[Any]): String = someList match {
    case List(42, _, _, _) => "Starts with awesomeness and has 4 items"
    case List(42, _*) => "Starts with awesomeness and has any items"
    case _ => "Dont know this"
  }

  println(listChecker(List(42)))
  println(listChecker(List(42, 1, 2, 3)))
  println(listChecker(List(1)))
}
