#!/bin/bash

java -jar scaledJob.jar &

while true; do
    status=$(curl -s http://$MY_POD_IP:8082/get/status)
    echo $status
    if [[ $status == "COMPLETED" ]]; then
        echo "Job is completed"
        break
    else
        echo "Job is $status"
        sleep 2
    fi
done
