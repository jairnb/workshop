#!/bin/bash

trap "kill 0" EXIT  # Kills all background processes on exit

./config-server-service/gradlew -p config-server-service bootRun &
./discovery-server-service/gradlew -p discovery-server-service bootRun &
./api-gateway-service/gradlew -p api-gateway-service bootRun &
./company-service/gradlew -p company-service bootRun &
wait