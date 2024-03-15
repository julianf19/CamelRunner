#!/bin/bash
echo | openssl s_client -connect mail.cofelygtc.com:993 2>&1 | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' > cofelygtc.crt
keytool -import -trustcacerts -keystore $JAVA_HOME/lib/security/cacerts -storepass changeit -noprompt -alias cofelygtc -file ./cofelygtc.crt

while true
do
  echo 'Starting from shell'
  java -jar ./target/camelrunner.jar ./conf/config.xml autorestart docker
  sleep 5  
done