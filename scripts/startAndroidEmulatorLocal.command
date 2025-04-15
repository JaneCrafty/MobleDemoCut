#!/bin/bash

echo "Starting android emulator"
date
appium -p 4723 &>${PWD}/appium4723.log &
java -jar ~/grid/selenium-server-4.1.1.jar standalone --config ~/grid/appium_config.toml --host localhost --port 8200 &>${PWD}/grid.log &
export LOG_DIR=${ANDROID_HOME}/logs

for HARDCODED_EMU_ID in 5554
do
	$ANDROID_HOME/emulator/emulator -avd android-${HARDCODED_EMU_ID} -wipe-data -port ${HARDCODED_EMU_ID} -skin 1080x1920 -no-boot-anim -no-audio -no-jni -gpu swiftshader_indirect -ranchu -qemu &>${PWD}/emulator-${HARDCODED_EMU_ID}.log &
	adb -s emulator-${HARDCODED_EMU_ID} wait-for-device shell 'while [[ -z $(getprop dev.bootcomplete) ]]; do sleep 5; done;'
	adb devices
	adb -s emulator-${HARDCODED_EMU_ID} shell settings get global package_verifier_enable
	adb -s emulator-${HARDCODED_EMU_ID} uninstall com.example.broker.beta --force >/dev/null || true
	adb -s emulator-${HARDCODED_EMU_ID} shell 'echo "chrome --disable-fre --no-default-browser-check --no-first-run --ignore-certificate-errors" > /data/local/tmp/chrome-command-line'
done