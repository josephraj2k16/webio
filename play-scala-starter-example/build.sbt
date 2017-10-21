name := """play-scala-starter-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")


scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % Test
libraryDependencies += "com.h2database" % "h2" % "1.4.194"
libraryDependencies += "com.github.sarxos" % "webcam-capture" % "0.3.11"
libraryDependencies += "com.typesafe.play" %% "play-native-loader" % "1.0.0"
libraryDependencies += "com.nativelibs4java" % "bridj" % "0.6.2"

