package circe_config_build
import cbt._
class Build(val context: Context) extends BaseBuild {
  override def defaultScalaVersion: String = "2.12.1"

  val circeVersion = "0.7.0"

  override def dependencies = (
    super.dependencies ++ // don't forget super.dependencies here for scala-library, etc.
      Seq(
        // source dependency
        // DirectoryDependency( projectDirectory ++ "/subProject" )
      ) ++
      // pick resolvers explicitly for individual dependencies (and their transitive dependencies)
      Resolver(mavenCentral, sonatypeReleases).bind(
        // CBT-style Scala dependencies
        // ScalaDependency( "com.lihaoyi", "ammonite-ops", "0.5.5" )
        // MavenDependency( "com.lihaoyi", "ammonite-ops_2.11", "0.5.5" )

        // SBT-style dependencies
        "com.typesafe" % "config" % "1.3.1",
        "io.circe" %% "circe-core" % circeVersion,
        "io.circe" %% "circe-generic" % circeVersion,
        "io.circe" %% "circe-parser" % circeVersion,
        "io.circe" %% "circe-java8" % circeVersion
      )
  )
}
