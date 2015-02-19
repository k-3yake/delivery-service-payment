name := """delivery-service-payment"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.webjars" % "angularjs" % "1.3.13"
)

pipelineStages := Seq(rjs, digest, gzip)
