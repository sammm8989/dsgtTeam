# dsgtTeam

![when-server-down-iceeramen](https://github.com/sammm8989/dsgtTeam/assets/100788554/3bce5a48-b448-445b-8fbe-fd9a0562edf3)

##Deployment:

- Copy the apis folder to the server
- Start a screen session for every api
- For SOAP and REST start the api by "java -jar SOAP.jar --server.port=8081" and "java -jar REST.jar --server.port=7070"
- For the RMI start rmiregistry with "rmiregistry &" in the same console run "java -Djava.rmi.server.hostname=dsgt.uksouth.cloudapp.azure.com server"

##Testing
- For RMI: run in folder testing "java client dsgt.uksouth.cloudapp.azure.com"
- For REST: curl -X GET dsgt.uksouth.cloudapp.azure.com:7070/restrpc/meals -H 'Content-type:application/json'
- For SOAP: run in folder testing "curl --header "content-type: text/xml" -d @request.xml http://dsgt.uksouth.cloudapp.azure.com:8081/ws"


## SERVERS:
### UK
ssh azureresource@dsgt.uksouth.cloudapp.azure.com
dsgt2024UKSouth

### Canada
ssh azureuser@dsgt.canadacentral.cloudapp.azure.com
dsgt2024Canada

### Brazilië
ssh asureuser@dsgt.brazilsouth.cloudapp.azure.com
dsgt2024Brazil

### Japan
ssh azureuser@dsgt2024team13.japaneast.cloudapp.azure.com
dsgt2024Japan

## PORTS
SOAP: 8081
REST: 7070
RMI: 1099
RMI RESPOND: 9090
