#!/bin/bash

URL="http://dsgt2024team13.japaneast.cloudapp.azure.com:7070/restrpc/meals"
TOTAL_REQUESTS=10000
CONCURRENCY=105
TIMEOUT=30
OUTPUT_FILE="japan_150_15000.tsv"

completed_requests=0

while [ $completed_requests -lt $TOTAL_REQUESTS ]; do
    ab -n $((TOTAL_REQUESTS - completed_requests)) -c $CONCURRENCY -t $TIMEOUT -g $OUTPUT_FILE $URL

    # Check if ab exited with a timeout error
    if [ $? -eq 2 ]; then
        echo "Timeout occurred. Continuing with remaining requests..."
    fi

    # Update the number of completed requests
    completed_requests=$(grep -c '^' $OUTPUT_FILE)
done
