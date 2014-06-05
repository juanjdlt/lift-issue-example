name := "dynamic-js-lift-example"

version := "1.0"

organization := "com.talenteca"

scalaVersion := "2.10.4"

resolvers ++= Seq(
  "Java.net Maven2 Repository"     at "http://download.java.net/maven/2/",
  "Sonatype scala-tools repo"      at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype scala-tools staging"   at "https://oss.sonatype.org/content/repositories/staging",
  "Sonatype scala-tools releases"  at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype scala-tools snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

seq(webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-optimize", "-deprecation", "-unchecked", "-feature", "-encoding", "utf8")

libraryDependencies ++= Seq(
  "net.liftweb"             %%  "lift-webkit"        % "3.0-SNAPSHOT"          % "compile",
  "org.eclipse.jetty"       %   "jetty-webapp"       % "9.1.5.v20140505"       % "container",
  "org.eclipse.jetty"       %   "jetty-plus"         % "9.1.5.v20140505"       % "container",
  "ch.qos.logback"          %   "logback-classic"    % "1.1.2",
  "org.specs2"              %%  "specs2"             % "2.3.11"                % "test",
  "net.databinder.dispatch" %%  "dispatch-core"      % "0.11.1",
  "net.databinder.dispatch" %%  "dispatch-tagsoup"   % "0.11.1",
  "javax.mail"              %   "mail"               % "1.4.7",
  "commons-validator"       %   "commons-validator"  % "1.4.0"
)

EclipseKeys.withSource := true

EclipseKeys.relativizeLibs := false

