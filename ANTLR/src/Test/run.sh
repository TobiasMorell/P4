#!/bin/bash/
export CLASSPATH=".:antlr-4.5-complete.jar:$CLASSPATH"

echo starting up...
java org.antlr.v4.runtime.misc.TestRig ObsidiCode prog -gui $1
