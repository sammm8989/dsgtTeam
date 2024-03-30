seq 6000 | xargs -n 1 -P 100 -I {} \
sh -c 'curl -X GET dsgt.uksouth.cloudapp.azure.com:7070/restrpc/meals \
-H "Content-type:application/json"; sleep 0.5'