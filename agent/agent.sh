#!/bin/sh

AGENT_JAR=target/agent-1.0.0-shaded.jar

java -jar $AGENT_JAR $AGENT_JAR $1 $2
