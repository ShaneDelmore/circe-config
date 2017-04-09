package io.delmore.circeConfig

import com.fortysevendeg.lambdatest._

object Main {
  def main(args: Array[String]): Unit =
    run("JsonConfig Tests", new JsonConfigTest)
}
