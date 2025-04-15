#!/bin/bash

xcrun simctl shutdown ${SIMULATOR_UUID} || true
pid=$(ps aux |grep "appium -p ${APPIUM_PORT}"| grep -v grep |awk '{print $2}') && kill $pid || true
xcrun simctl list | grep Booted | awk -F "[()]" '{ for (i=2; i<NF; i+=2) print $i }' | grep '^[-A-Z0-9]*$' | xargs -I uuid xcrun simctl shutdown uuid || true