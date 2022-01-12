package lectures

object StringOps extends App {

  //this also works with collections
  val myStr1: String = "Hello World"

  //prepend
  println('a' +: myStr1)  //aHello World

  //append
  println(myStr1 :+ 'a') //Hello Worlda

  //prepend multiple
  println(myStr1 ++ myStr1) //Hello WorldHello World
}
