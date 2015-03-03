name := """delivery-service-payment"""

version := "1.0"

scalaVersion := "2.11.1"

lazy val root = (project in file(".")).enablePlugins(PlayScala).disablePlugins(plugins.JUnitXmlReportPlugin)

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
  ,"org.webjars" % "angularjs" % "1.3.13"
  ,"org.webjars" % "angular-protractor" % "1.6.1"
)

testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "junitxml", "console")
