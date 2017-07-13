import sbt._
import Keys._

import sbtassembly.AssemblyKeys._
import sbtassembly.{PathList, MergeStrategy}

/************************************************************
 * 说明:
 * 1. 编译管理
 ************************************************************/
object Common {

  val APP_VERSION = "0.0.1"
  val SCALA_VERSION = "2.11.5"
  val ORGANIZATION = "com.ibm.topscore"

  val settings: Seq[Def.Setting[_]] = Seq(

    version := APP_VERSION,
    scalaVersion := SCALA_VERSION,
    organization := ORGANIZATION,

    javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xmx2G"),
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-optimize","-feature"),
    fork := true,

    test in assembly := {},

    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
      case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
      case PathList("javax", "transaction", xs @ _*) => MergeStrategy.first
      case PathList(xs @ _*) if xs.last endsWith ".properties" => MergeStrategy.filterDistinctLines 
      case PathList(xs @ _*) if xs.last endsWith ".xml" => MergeStrategy.first
      case PathList(xs @ _*) if xs.last endsWith ".html" => MergeStrategy.discard
      
      case x =>
        val oldStrategy = (assemblyMergeStrategy in assembly).value
        oldStrategy(x)
    },
    
    resolvers += Opts.resolver.mavenLocalFile,
    
    // Resolver Repository
    resolvers ++= Seq(DefaultMavenRepository,
      Resolver.defaultLocal,
      Resolver.mavenLocal,
      "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
      "Aliyun Maven2 Snapshots" at "http://maven.aliyun.com/nexus/content/groups/public",
      "Apache Staging" at "https://repository.apache.org/content/repositories/staging/",
      Classpaths.typesafeReleases,
      "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      "Java.net Maven2 Repository" at "http://download.java.net/maven/2/",
      Classpaths.sbtPluginReleases,
      "Eclipse repositories" at "https://repo.eclipse.org/service/local/repositories/egit-releases/content/"
      )
  )
}