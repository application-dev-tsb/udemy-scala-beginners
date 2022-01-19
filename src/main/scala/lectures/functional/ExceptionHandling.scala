package lectures.functional

import scala.util.{Failure, Success, Try}

object ExceptionHandling extends App {

  def unsafeMethod(throwError: Boolean): String = if (throwError) throw new RuntimeException("Throw an error") else "OK"

  def safeMethod(throwError: Boolean): Try[String] = Try(unsafeMethod(throwError))

  def backupMethod(): Try[String] = Success("OK Backup")

  val fallback: Try[String] = Try(unsafeMethod(true)) orElse backupMethod()
  val betterFallback: Try[String] = safeMethod(true) orElse backupMethod()


  val configOptions: Map[String, String] = Map(
    "url" -> "https://localhost",
    "port" -> "8080"
  )

  //the hard way
  val maybeUrl = Try(configOptions("url"))
  val maybePort = Try(configOptions("port"))
  val maybeConnection: Try[String] = maybeUrl.flatMap(url => maybePort.flatMap(port => Success(s"$url:$port")))
  maybeConnection.foreach(println)

  //using for comprehension
  val maybeConnectionBetter = for {
    url <- Try(configOptions("url"))
    port <- Try(configOptions("port"))
  } yield {
    s"$url:$port"
  }

  maybeConnectionBetter.foreach(println)

}
