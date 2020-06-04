
inThisBuild(List(
  organization := "io.github.alexarchambault.sbt",
  homepage := Some(url("https://github.com/alexarchambault/sbt-compatibility")),
  licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      "alexarchambault",
      "Alexandre Archambault",
      "",
      url("https://github.com/alexarchambault")
    )
  )
))

lazy val `sbt-compatibility` = project
  .enablePlugins(ScriptedPlugin)
  .settings(
    sbtPlugin := true,
    scriptedLaunchOpts += "-Dplugin.version=" + version.value,
    scriptedBufferLog := false,
    sonatypeProfileName := "io.github.alexarchambault",
    addSbtPlugin("com.typesafe" % "sbt-mima-plugin" % "0.7.0"),
    libraryDependencies ++= Seq(
      "io.github.alexarchambault" %% "data-class" % "0.2.3" % Provided,
      compilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
    ),
    libraryDependencies += "io.get-coursier" %% "versions" % "0.1.0",
    libraryDependencies += "com.lihaoyi" %% "utest" % "0.7.4" % Test,
    testFrameworks += new TestFramework("utest.runner.Framework")
  )

lazy val `sbt-eviction-warnings-dummy` = project
  .in(file("target/dummy"))
  .settings(
    sonatypeProfileName := "io.github.alexarchambault"
  )
