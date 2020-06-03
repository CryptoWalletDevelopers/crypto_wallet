#!/bin/sh

info()
{
  echo ""
  echo "********************************************************************************"
  echo "$@"
  echo "********************************************************************************"
  echo ""
}

cd /deploy

info "Compile JAR file..."
./mvnw -Dmaven.test.skip=true package

info "Migrations..."
rm /build/flyway-6.4.3/jre/bin/java
flyway -configFiles=/deploy/src/main/resources/flyway.conf migrate

info "Start application..."
java -jar /deploy/target/wallet-0.0.1-SNAPSHOT.war