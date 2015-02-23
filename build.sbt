name := """delivery-service-payment"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
  ,"org.webjars" % "angularjs" % "1.3.13"
  ,"org.webjars" % "angular-protractor" % "1.6.1"
)

val integrationTest = taskKey[Unit]("Execute integration Test")

integrationTest := {
  val sum = 1 + 3
  println("sum: " + sum)
  sum
}

