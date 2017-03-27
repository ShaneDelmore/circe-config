name := "circe-config"

version := "1.0"

scalaVersion := "2.11.8"

val circeVersion = "0.7.0"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.1",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "io.circe" %% "circe-java8" % circeVersion
)
