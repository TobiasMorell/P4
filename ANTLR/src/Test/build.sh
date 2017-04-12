#!/bin/bash
export CLASSPATH=".:antlr-4.5-complete.jar:$CLASSPATH"

echo building the parser via ANTLR4...
java -Xmx500M -cp "antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool -package ObsidiCode.g4
echo compiling paser...
javac ObsidiCode*.java
