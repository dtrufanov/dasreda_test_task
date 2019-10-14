name := """dasreda-test-task"""
organization := "trufanov"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.0"

libraryDependencies ++= Seq(
  guice,
  javaJdbc,
  evolutions,
  "org.mybatis" % "mybatis" % "3.3.0",
  "org.mybatis" % "mybatis-guice" % "3.6",
  //"com.google.inject.extensions" % "guice-multibindings" % "4.0",
  "com.h2database" % "h2" % "1.4.192"
)
