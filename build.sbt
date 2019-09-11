lazy val app = (project in file("app"))
  .settings(
    name := "jimmy-app",
    organization := "com.jimmy.learning",
    version := "1.0.0",
    scalaVersion := "2.12.9"

)

lazy val util = (project in file("util"))
  .settings(
    name := "jimmy-util",
    organization := "com.jimmy.learning",
    version := "0.1.0",
    scalaVersion := "2.12.9"
  )