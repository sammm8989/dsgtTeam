#!/bin/bash

# Kill all existing screens
killall screen

# Start rmiregistry in a detached screen session
screen -dmS rmiregistry rmiregistry

# Wait for a moment before starting the RMI server
sleep 1

# Start RMI server in a detached screen session
screen -dmS RMI java -Djava.rmi.server.hostname=dsgt2024team13.japaneast.cloudapp.azure.com  server

# Wait for a moment before starting the SOAP server
sleep 1

# Start SOAP server in a detached screen session
screen -dmS SOAP java -jar SOAP.jar --server.port=8081

# Wait for a moment before starting the REST server
sleep 1

# Start REST server in a detached screen session
screen -dmS REST java -jar REST.jar --server.port=7070
