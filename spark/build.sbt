name := MyBuild.NamePrefix + "spark"

assemblyJarName := MyBuild.NamePrefix + "spark" + ".jar"

mainClass in (Compile, run) := Some("spark.SparkMain")
