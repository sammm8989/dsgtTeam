seq 10000 | xargs -n 1 -P 5000 -I {} \
curl --header "content-type: text/xml" -d @request.xml http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws