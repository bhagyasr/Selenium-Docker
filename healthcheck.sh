#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE
# USE 8080 if grid is running
# USE 4444 if entire YAML along with module services is up

echo "Checking if hub is ready - $host"

while [ "$( curl -s http://$host:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
    -Dhost=$host \
    -DBrowser=$Browser \
    org.testng.TestNG $MODULE