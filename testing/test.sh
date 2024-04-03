start_time_20=$(date +"%s")
ab -n 100000 -c 10 -g SOAP/duration_10.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
end_time_20=$(date +"%s")
duration_20=$((end_time_20 - start_time_20))
echo "Duration: $duration_20 seconds"