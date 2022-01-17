package lectures.functional

import scala.util.Random

object VectorVsList extends App {


  val maxRuns = 1000
  val maxCapacity = 1_000_000

  def getWriteTime(collection: Seq[Int]): Double = {

    val r = new Random

    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())

      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  //List
  // Pro:
  // - reference to tails
  // Con:
  // - update in the mid of list is slow
  println(getWriteTime(numbersList)) //9995336.0

  //Vector
  //Pro:
  //Con:
  // - updating requires replacing a 32-element chunk
  println(getWriteTime(numbersVector)) //2778.5
}
