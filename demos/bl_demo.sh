mkdir -p build
javac -sourcepath ../src -d build ../src/*/*.java
java -cp build Oryphis.Main $@
