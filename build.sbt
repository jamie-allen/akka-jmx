scalaVersion := "2.10.0"

name := "akka-jmx"

scalacOptions ++= Seq("-unchecked", "-deprecation")

//scalaVersion := "2.11.0-SNAPSHOT"
//scalaOrganization := "org.scala-lang.macro-paradise"
//resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
          "com.typesafe.akka" %% "akka-actor" % "2.1.0",
          "com.typesafe.akka" %% "akka-testkit" % "2.1.0" % "test",
          "org.scalatest" %% "scalatest" % "1.9.1",
          "junit" % "junit" % "4.7" % "test"
				  )

