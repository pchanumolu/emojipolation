import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "io.github.todokr",
      scalaVersion := "2.12.1",
      version      := "0.2.0"
    )),
    name := "emojipolation",
    libraryDependencies ++= Seq(
      "com.vdurmont"   % "emoji-java" % "3.2.0",
      "org.scalamacros" % "paradise_2.12.1" % "2.1.0",
      scalaTest % Test
    )
  )

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/todokr/emojipolation</url>
  <licenses>
    <license>
      <name>MIT License</name>
      <url>http://www.opensource.org/licenses/mit-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/todokr/emojipolation</url>
    <connection>scm:git:https://github.com/todokr/emojipolation.git</connection>
  </scm>
  <developers>
    <developer>
      <id>todokr</id>
      <name>Shunsuke Tadokoro</name>
      <url>https://github.com/todokr</url>
    </developer>
  </developers>)