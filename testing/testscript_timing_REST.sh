#start_time_100=$(date +"%s")
#ab -n 100000 -c 100 -g REST/duration_100.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
#end_time_100=$(date +"%s")
#duration_100=$((end_time_100 - start_time_100))
#echo "Duration: $duration_100 seconds"
#sleep 200

start_time_120=$(date +"%s")
ab -n 100000 -c 120 -g REST/duration_120.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
end_time_120=$(date +"%s")
duration_120=$((end_time_120 - start_time_120))
echo "Duration: $duration_120 seconds"
sleep 200
#
#start_time_150=$(date +"%s")
#ab -n 100000 -c 150 -g REST/duration_150.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
#end_time_150=$(date +"%s")
#duration_150=$((end_time_150 - start_time_150))
#echo "Duration: $duration_150 seconds"
#sleep 200
#
#start_time_200=$(date +"%s")
#ab -n 100000 -c 200 -g REST/duration_200.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
#end_time_200=$(date +"%s")
#duration_200=$((end_time_200 - start_time_200))
#echo "Duration: $duration_200 seconds"
#
#sleep 200
#
#start_time_400=$(date +"%s")
#ab -n 100000 -c 400 -g REST/duration_400.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
#end_time_400=$(date +"%s")
#duration_400=$((end_time_400 - start_time_400))
#echo "Duration: $duration_400 seconds"
#sleep 200
#
#start_time_800=$(date +"%s")
#ab -n 100000 -c 800 -g REST/duration_800.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
#end_time_800=$(date +"%s")
#duration_800=$((end_time_800 - start_time_800))
#echo "Duration: $duration_800 seconds"
#
#sleep 200

start_time_75=$(date +"%s")
ab -n 100000 -c 75 -g REST/duration_75.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
end_time_75=$(date +"%s")
duration_75=$((end_time_75 - start_time_75))
echo "Duration: $duration_75 seconds"

sleep 200

start_time_50=$(date +"%s")
ab -n 100000 -c 50 -g REST/duration_50.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
end_time_50=$(date +"%s")
duration_50=$((end_time_50 - start_time_50))
echo "Duration: $duration_50 seconds"
sleep 200

start_time_40=$(date +"%s")
ab -n 100000 -c 40 -g REST/duration_40.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
end_time_40=$(date +"%s")
duration_40=$((end_time_40 - start_time_40))
echo "Duration: $duration_40 seconds"
sleep 200

start_time_30=$(date +"%s")
ab -n 100000 -c 30 -g REST/duration_30.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
end_time_30=$(date +"%s")
duration_30=$((end_time_30 - start_time_30))
echo "Duration: $duration_30 seconds"
sleep 200

start_time_20=$(date +"%s")
ab -n 100000 -c 20 -g REST/duration_20.tsv 'http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals'
end_time_20=$(date +"%s")
duration_20=$((end_time_20 - start_time_20))
echo "Duration: $duration_20 seconds"

echo @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
echo "Duration 20 is: $duration_20 seconds"
echo "Duration 30 is: $duration_30 seconds"
echo "Duration 40 is: $duration_40 seconds"
echo "Duration 50 is: $duration_50 seconds"
echo "Duration 75 is: $duration_75 seconds"
echo "Duration 100 is: $duration_100 seconds"
#echo "Duration 120 is: $duration_120 seconds"
#echo "Duration 150 is: $duration_150 seconds"
#echo "Duration 200 is: $duration_200 seconds"
#echo "Duration 400 is: $duration_400 seconds"
#echo "Duration 800 is: $duration_800 seconds"
echo @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
