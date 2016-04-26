mkdir -p build
javac -sourcepath src -d build src/*/*.java -Xlint:deprecation
java -cp build Oryphis.Main $@
