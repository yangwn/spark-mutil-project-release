import sbt._
import Keys._


/*********************************************************************************************
 * Jar包管理: 
 *  1).jar的依赖与依赖关系
 *  2).打包策略
 *
 * Notice:
 *  %% --> find jar for specified scala version.
 *  %  --> don't need specified scala version. For example, the lib compile with Java.
 *********************************************************************************************/
object Dependencies {

  //Common
  val commonDependencies: Seq[ModuleID] = Seq(
    "org.scalaz" %% "scalaz-core" % "7.2.14",
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  )
  
  //Json
  val json : Seq[ModuleID] = Seq(
      // "io.argonaut" %% "argonaut" % "6.0.4",
      // "com.propensive" %% "rapture-json-argonaut" % "1.1.0",
      // "com.typesafe.play" %% "play-json" % "2.4.2"
  )

  //Utils
  val utilsDependencies  : Seq[ModuleID] = commonDependencies

  //Core
  val coreDependencies   : Seq[ModuleID] = commonDependencies
  
  //Elastic Search
  val searchDependencies : Seq[ModuleID] = commonDependencies ++ Seq(
    "com.sksamuel.elastic4s" %% "elastic4s-core" %  "1.7.0",
    "com.sksamuel.elastic4s" %% "elastic4s-testkit" % "1.7.0" % "test"
  )
  
  //Spark
  val sparkVersion = "2.1.1"
  val sparkDependencies  : Seq[ModuleID] = commonDependencies ++ Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided"
  )

}