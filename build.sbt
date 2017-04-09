name := "circe-config"

version := "1.0"

scalaVersion := "2.12.1"

val circeVersion = "0.7.1"

testFrameworks += new TestFramework("com.fortysevendeg.lambdatest.sbtinterface.LambdaFramework")

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.1",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "io.circe" %% "circe-java8" % circeVersion,
  "com.fortysevendeg" %% "lambda-test" % "1.3.0" % Test
)
