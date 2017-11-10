name := "akka_profile"

version := "1.0"

scalaVersion  := "2.11.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
	val akkaV = "2.3.6"
	val sprayV = "1.3.2"
	Seq(
		"io.spray"            %%  "spray-can"     % sprayV withSources() withJavadoc(),
		"io.spray"            %%  "spray-routing" % sprayV withSources() withJavadoc(),
		"io.spray"            %%  "spray-json"    % "1.3.3",
		"io.spray"            %%  "spray-testkit" % sprayV  % "test",
		"com.typesafe.akka"   %% "akka-http-spray-json" % "10.0.8",
		"com.typesafe.akka"   %%  "akka-actor"    % akkaV,
		"com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
		"org.specs2"          %%  "specs2-core"   % "2.3.11" % "test",
		"org.scalaz"          %%  "scalaz-core"   % "7.1.0",
		"com.typesafe.akka" %% "akka-http" % "10.0.9",
		"com.typesafe.akka" %% "akka-http-testkit" % "10.0.9" % Test,
		"com.typesafe.akka" %% "akka-stream" % "2.5.3",
		"com.typesafe.akka" %% "akka-stream-testkit" % "2.5.3" % Test,
		"com.typesafe.slick" %% "slick" % "3.0.0",
		"com.typesafe.slick" %% "slick-codegen" % "3.0.0",
		"org.slf4j" % "slf4j-nop" % "1.6.4",
		"com.roundeights" %% "hasher" % "1.2.0"
	)
}

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.34"
