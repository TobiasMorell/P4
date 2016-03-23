#!/bin/bash
export CLASSPATH=".:antlr-4.5-complete.jar:$CLASSPATH"

java -Xmx500M -cp "antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool ObsidiCode.g4
javac ObsidiCode*.java

