cancelable in Global := true

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1",
  "org.seleniumhq.selenium" % "selenium-java" % "3.4.0",
  "org.apache.commons" % "commons-lang3" % "3.6",
  "org.apache.commons" % "commons-text" % "1.1"
)

name := "Example-Testing-Project"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.2"

parallelExecution in Test := false

        