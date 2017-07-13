name := MyBuild.NamePrefix + "search"

assemblyJarName := MyBuild.NamePrefix + "search" + ".jar"

mainClass in (Compile, run) := Some("search.SearchMain")
