#!/bin/bash

echo "Starting ios simulator"
date
mkdir -p ${CI_PROJECT_DIR}/SumSubImage
curl -s ${NEXUS_REPO_URL}/qamain-jbin/Non-removable_directory/sumSubImage/PassportPhoto.jpeg -o ./SumSubImage/PassportPhoto.jpeg
curl -o ./chr.zip https://chromedriver.storage.googleapis.com/74.0.3729.6/chromedriver_mac64.zip
unzip chr.zip
pid=$(ps aux |grep "appium -p ${APPIUM_PORT}"| grep -v grep |awk '{print $2}') && kill $pid || true
xcrun simctl list | grep Booted | awk -F "[()]" '{ for (i=2; i<NF; i+=2) print $i }' | grep '^[-A-Z0-9]*$' | xargs -I uuid xcrun simctl shutdown uuid || true
xcrun simctl shutdown ${SIMULATOR_UUID} || true
appium -p ${APPIUM_PORT} &>${PWD}/appium-${APPIUM_PORT}.log &
ls -la
xcrun simctl boot ${SIMULATOR_UUID} || true
open -a Simulator.app
sleep 30
xcrun simctl list | grep Booted
date