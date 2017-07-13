= SBT Base Project

*SBT Base Project* is a very basic application direction of mutil modules:

. link:common[Common Service] - serves up base common modules for project
. link:core[Core Service] - presents core module for project
. link:utils[Utils Service] - presents utils module for project
. link:spark[Spark Service] - presents spark module for project
. link:search[Search Service] - presents search module for project

== Building

. Using SBT, build and package the application, you need to setup sbt tools.

For package one jar, Please using this commond:
+
----
$ sbt clean compile eclipse
----
+

For package one jar, Please using this commond:
+
----
$ sbt assembly
----
+
SBT will automatically download all of _project_'s dependencies. This may take a few moments.


== Packaging whole. 
+
----
$ spark/target/scala-2.1.1/**.jar
----
+
