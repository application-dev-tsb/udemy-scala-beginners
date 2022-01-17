package lectures.functional

object TuplesAndMaps extends App {

  val myTuple = Tuple2(2, "Hello World") // (Int, String)
  val myBetterTuple =  (2, "Hello Better World")

  //things you can do on tuples
  println(myBetterTuple._1) //2
  println(myBetterTuple.copy(_2 = "By Java!"))
  println(myBetterTuple.swap)


  val myMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 123), ("Daniel", 144))
    .withDefaultValue(-1) //obvious

  val syntacticSugarMap = Map(
    "Lyndon" -> 123,
    "Test" -> 124
  )

  //things we can do with maps
  println(syntacticSugarMap.contains("Lyndon"))
  println(syntacticSugarMap("Lyndon"))
  println(phoneBook("does not exist")) //-1
}
