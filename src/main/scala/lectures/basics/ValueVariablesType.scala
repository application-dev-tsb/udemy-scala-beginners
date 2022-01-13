package lectures.basics

object ValueVariablesType extends App {

  /**
   * constants (val) and variables (var)
   * in functional scala, we should always be using vals
   * instead of vars (side effects)
   */
  val a: Int = 42
  var b: Int = a
  b += 1

  //a=42, b=43
  println(s"a=$a b=$b")

  val x = 123.123
  println(s"Type: ${x.getClass}")


  /**
   * data types:
   * integer, floats, booleans
   */
  val justByte: Byte = 127
  val intShort: Short = 32767
  val int32: Int = 2147483647
  val intLong: Long = 9223372036854775807

  val float32: Float = 12.2222222222222
  val float64: Double = 12.0000000000000000000000000000000000000000000000
  val floatBig: BigDecimal = 1233333333333333333333333333333333333333333.333333333333333333333333333333
  println(s"Long=$intLong \nBigDecimal=$floatBig")

  val myChar: Char = 'A'
  val myString: String = "Hello World"

  val myBool: Boolean = true

  val myUnit: Unit = (println("Test"))
  println(myUnit) //()

  var myAny: Any = BigDecimal(1)
  var myAnyRef: AnyRef = BigDecimal(1)

}
