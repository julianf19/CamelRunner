#!/bin/bash
while true
#do
#  echo 'Starting from shell'
#  java -Dlog4j.configuration=file:./conf/log4j.properties -jar ./target/CamelRunner.jar ./conf/config.xml
#  sleep 1  
#done

do
  java -Dcom.ibm.mq.cfg.useIBMCipherMappings=false -Djava.library.path=file:./lib -Dlog4j.configuration=file:./conf/log4j.xml -DWorkflowName=$WORKFLOW_NAME -jar ./target/camelrunner.jar ./conf/config.xml autorestart docker
  sleep 5
done
