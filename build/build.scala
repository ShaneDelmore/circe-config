package circe_config_build
import cbt._
import java.io.File

class Build(val context: Context) extends BaseBuild with SbtLayout { outer =>
  override def defaultScalaVersion: String = "2.12.1"

  val circeVersion = "0.7.1"

  override def dependencies = (
    super.dependencies ++ // don't forget super.dependencies here for scala-library, etc.
      Resolver(mavenCentral, sonatypeReleases).bind(
        // SBT-style dependencies
        "com.typesafe" % "config" % "1.3.1",
        "io.circe" %% "circe-core" % circeVersion,
        "io.circe" %% "circe-generic" % circeVersion,
        "io.circe" %% "circe-parser" % circeVersion,
        "io.circe" %% "circe-java8" % circeVersion
      )
  )

}

trait SbtLayout { outer: BaseBuild =>
  override def sources = Seq(projectDirectory ++ "/src/main/scala")

  override def test: Dependency =
    new BasicBuild(context) {
      override def defaultScalaVersion: String = outer.defaultScalaVersion
      override def fork = true //Tests won't load due to classloader issues without forking
      //      override def flatClassLoader = true

      override def sources = Seq(projectDirectory ++ "/src/test/scala")
      override def compileTarget = super.compileTarget.getParentFile ++ "/test-classes"

      override def dependencies =
        super.dependencies ++
          Resolver(mavenCentral, sonatypeReleases).bind(
            "com.fortysevendeg" %% "lambda-test" % "1.3.0"
          ) :+ outer

    }
}
