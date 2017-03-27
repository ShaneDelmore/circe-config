import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import io.circe.java8.time._
import JsonConfig._
import java.time._

object main {
  case class SystemProperties(system: System)
  case class System(
    javaversion: String,
    userhome: String,
    home: String,
    pwd: String,
    shell: String,
//    lang: Option[String],
    path: String
  )
  case class DurationProperties(durations: Durations)
  case class Durations(second: Instant)

  def main(args: Array[String]): Unit = {
    val systemProperties = decode[SystemProperties](configJson).toString
    val durationProperties = decode[Durations](configJson).toString
    println(durationProperties)
  }
}
