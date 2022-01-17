package lectures.functional

object TuplesAndMaps extends App {

  val myTuple = Tuple2(2, "Hello World") // (Int, String)
  val myBetterTuple =  (2, "Hello Better World")

  //things you can do on tuples
  println(myBetterTuple._1) //2
  println(myBetterTuple.copy(_2 = "By Java!"))
  println(myBetterTuple.swap)


}
