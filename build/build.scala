package circe_config_build
import cbt._
import java.io.File

class Build(val context: Context) extends BaseBuild { outer =>
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
        "io.circe" %% "circe-java8" % circeVersion,
        "com.fortysevendeg" %% "lambda-test" % "1.3.0"
      )
  )

  override def test: Dependency = {
    val testDirectory = projectDirectory / "src" / "test"
    new BasicBuild(context.copy(workingDirectory = testDirectory)) {
      println("projectDir")
      println(projectDirectory)
      println("creating build")
//      override def sources: Seq[File] = Seq(testDirectory)

      override def sources: Seq[File] = (
        Seq[File]() ++
          projectDirectory.listRecursive.toVector.filter(_.toString.endsWith(".scala"))
      )

      println(sources)

      override def dependencies = outer.dependencies ++ super.dependencies
      def apply = run
    }
  }
}
