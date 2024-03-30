seq 10000 | xargs -n 1 -P 99 -I {} \
sh -c 'retry=3; while [ $retry -gt 0 ]; do \
echo "Making request {}"; \
curl -X GET dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals -H "Content-type:application/json" && break; \
retry=$(($retry - 1)); sleep 1; done'
