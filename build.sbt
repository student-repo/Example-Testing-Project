


cancelable in Global := true

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1",
  "org.seleniumhq.selenium" % "selenium-java" % "3.4.0",
  "org.apache.commons" % "commons-lang3" % "3.6",
  "org.apache.commons" % "commons-text" % "1.1",
  "com.relevantcodes" % "extentreports" % "2.41.2",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6"
)

name := "Example-Testing-Project"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.2"

testGrouping <<= definedTests in Test map { tests =>
  tests.map { test =>
    import Tests._

     Group(
      name = test.name,
      tests = Seq(test),
      runPolicy = InProcess)
  }.sortWith(_.name < _.name)
}



lazy val generate = taskKey[Unit]("Generate my file")

generate := (runMain in Compile).toTask("Main").value


lazy val generate2 = taskKey[Unit]("Generate my file")

generate2 := (runMain in Compile).toTask("Main2").value



//lazy val itTestTask: Initialize[Task[Unit]] = Def.taskDyn {
//  for {
//    results <- (executeTests in IntegrationTest)
//  } yield { Tests.showResults(streams.value.log, results, "test missing?") }
//}





//private lazy val itSettings =
//  inConfig(IntegrationTest)(Defaults.testSettings) ++
//    Seq(
//      fork in IntegrationTest := false,
//      parallelExecution in IntegrationTest := false,
//      scalaSource in IntegrationTest := baseDirectory.value / "src/it/scala")
//
//







lazy val testAll = TaskKey[Unit]("test-all")

lazy val hello = taskKey[Unit]("Prints 'Hello World'")
hello := println("hello world!")

//lazy val hello1 = taskKey[Unit]({
//  inProjects(com.)
//
//})
//hello1 := println("hello world!")

//compile in Compile <<= (compile in Compile) map { _ =>
//  com.pages
//}

parallelExecution in Test := false

        