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

  //MULTI-PATTERN
  def listEmptinessMatcher(someList: List[Int]): Boolean = someList match {
    case List() | List(0) | List(0, 0) => true
    case _ => false
  }

  println(listEmptinessMatcher(List()))
  println(listEmptinessMatcher(List(0)))
  println(listEmptinessMatcher(List(1)))

  //NAME BINDING
  def listEmptinessMatcherWithNameBinding(someList: List[Int]): String = someList match {
    case a @ (List() | List(0) | List(0, 0)) => s"The list is empty: $a"
    case a @ _ => s"This is the list: $a"
  }

  println(listEmptinessMatcherWithNameBinding(List()))
  println(listEmptinessMatcherWithNameBinding(List(1)))

  //IF GUARDS
  def startsWith42(theList: List[Int]): Boolean = theList match {
    case List(theFirstNumber, _*) if theFirstNumber == 42 => true
    case _ => false
  }

  println(startsWith42(List(1, 2, 3)))
  println(startsWith42(List(42, 2, 3)))

  //SOME WEIRD SHIT
  val a :: b = List(1, 2, 3, 4, 1, 42)
  println(s"a=$a, b=$b")

  //PARTIAL FUNCTION
  val mappedList = b.map {
    case v if v % 2 == 0 => s"$v is even"
    case 1 => "the ONE"
    case v => s"$v is odd"
  }

  println(mappedList)
}
