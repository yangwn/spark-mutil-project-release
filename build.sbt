name := MyBuild.NamePrefix + "root"

version := Common.APP_VERSION

scalaVersion := Common.SCALA_VERSION

organization := Common.ORGANIZATION

lazy val common = project.
    settings(Common.settings: _*)

lazy val utils = project.
    settings(Common.settings: _*).
    settings(libraryDependencies ++= Dependencies.utilsDependencies)

lazy val core = project.
    dependsOn(utils).
    settings(Common.settings: _*).
    settings(libraryDependencies ++= Dependencies.coreDependencies)

lazy val spark = project.
    dependsOn(common, utils, core).
    settings(Common.settings: _*).
    settings(libraryDependencies ++= Dependencies.sparkDependencies)

lazy val search = project.
    dependsOn(core, common).
    settings(Common.settings: _*).
    settings(libraryDependencies ++= Dependencies.searchDependencies)

// lazy val root = (project in file(".")).
//     aggregate(core, common, utils, search, spark)