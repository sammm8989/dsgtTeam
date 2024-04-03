#!/bin/bash

# Define your output CSV file
outputCSV="ab_results.csv"

# Optionally, initialize the CSV file with headers
echo "Iteration" > "$outputCSV"

for i in {1..20}; do
    # Execute ab and generate TSV file
    ab -n 500 -c 10 -g SOAP/japan_10_10000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws

    # Check if the TSV file exists
    if [ -f "SOAP/japan_10_10000.tsv" ]; then
        # Append the TSV content to the CSV file
        tail -n +2 "SOAP/japan_10_10000.tsv" >> "$outputCSV"
        echo "TSV file appended to CSV file in iteration $i"
    else
        echo "TSV file not found in iteration $i"
    fi

    sleep 5
done



#ab -n 10000 -c 20 -g SOAP/japan_20_10000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
#ab -n 10000 -c 30 -g SOAP/japan_30_10000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
#ab -n 10000 -c 40 -g SOAP/japan_40_10000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
#ab -n 10000 -c 50 -g SOAP/japan_50_10000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
#ab -n 10000 -c 75 -g SOAP/japan_75_10000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
#ab -n 10000 -c 100 -g SOAP/japan_100_10000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
#ab -n 4000 -c 120 -g SOAP/japan_120_4000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
#ab -n 4000 -c 150 -g SOAP/japan_150_4000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
#ab -n 3000 -c 200 -g SOAP/japan_120_3000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
#ab -n 3000 -c 400 -g SOAP/japan_400_3000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws
#ab -n 3000 -c 800 -g SOAP/japan_800_3000.tsv http://dsgt2024team13.japaneast.cloudapp.azure.com:8081/ws