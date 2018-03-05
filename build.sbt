name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.11"

libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs
libraryDependencies += "org.mockito" % "mockito-core" % "2.10.0" % "test"
libraryDependencies ++= Seq(
  ws
)
// https://mvnrepository.com/artifact/com.github.tomakehurst/wiremock
libraryDependencies += "com.github.tomakehurst" % "wiremock" % "1.33" % Test

