package lectures.functional

import scala.util.{Failure, Success, Try}

object ExceptionHandling extends App {

  def unsafeMethod(throwError: Boolean): String = if (throwError) throw new RuntimeException("Throw an error") else "OK"

  def safeMethod(throwError: Boolean): Try[String] = Try(unsafeMethod(throwError))

  def backupMethod(): Try[String] = Success("OK Backup")

  val fallback: Try[String] = Try(unsafeMethod(true)) orElse backupMethod()
  val betterFallback: Try[String] = safeMethod(true) orElse backupMethod()




}
