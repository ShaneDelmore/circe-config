package io.delmore.circeConfig

import com.fortysevendeg.lambdatest._

class JsonConfigTest extends LambdaTest {

  val act = label("Initial Tests") {
    test("Eq test") {
      assertEq(2 + 1, 3, "Int eq test")
    }
  } +
    label("Simple Tests") {
      test("Assert Test") {
        assert(3 == 5 - 2, "should work")
      }
    }
}
