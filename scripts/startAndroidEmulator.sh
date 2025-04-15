#!/bin/bash

echo "Starting android emulator"
date
mkdir -p ${CI_PROJECT_DIR}/logs
mkdir -p ${CI_PROJECT_DIR}/SumSubImage
curl -s ${NEXUS_REPO_URL}/qamain-jbin/Non-removable_directory/sumSubImage/PassportPhoto.jpeg -o ./SumSubImage/PassportPhoto.jpeg
if test -f "chromedriver"; then
    echo "chromedriver exists, skipping download"
else
  curl -o ./chr.zip https://chromedriver.storage.googleapis.com/83.0.4103.14/chromedriver_linux64.zip
  unzip chr.zip
fi
appium -p ${APPIUM_PORT} &>${PWD}/appium-${APPIUM_PORT}.log &
java -jar ~/Grid/selenium-server-4.1.1.jar standalone --config ~/Grid/appium_config.toml --host localhost --port 8200 &>${PWD}/grid.log &
export LOG_DIR=${CI_PROJECT_DIR}/logs
adb devices

#The subfolder android/emulator contains android emulator v33, the more recent version that most tests are using
#However, version 33 has a bug which prevents using of proxy, see https://issuetracker.google.com/issues/276013088?pli=1
#So subfolder android-proxy/emulator contains emulator v32 which doesn't have the bug, for use with  tests that don't need proxy
#apparently is fixed in version 34.1.20

EMU="${ANDROID_HOME}/emulator/emulator"

if [ "$USE_PROXY_TRADER" = true ] ; then
    echo 'USING PROXY INDIA FOR TRADER'
    EMU="$ANDROID_HOME-proxy/emulator/emulator"
    PROXY_PARAM_NAME="-http-proxy"
    PROXY_PARAM_VALUE="${PROXY_CONNECTION_STRING_INDIA} -verbose -dns-server 8.8.8.8"
fi

if [ "$USE_PROXY_MODERATOR" = true ] ; then
    echo 'USING PROXY GERMANY FOR MODERATOR'
    EMU="$ANDROID_HOME-proxy/emulator/emulator"
    PROXY_PARAM_NAME="-http-proxy"
    PROXY_PARAM_VALUE="${PROXY_CONNECTION_STRING_GERMANY} -verbose -dns-server 8.8.8.8"
fi

for ID in 5554 5556 5558 5560 5562 5564 5566 5568
do
	$EMU -avd android-${ID} -port ${ID} ${PROXY_PARAM_NAME} ${PROXY_PARAM_VALUE} -wipe-data -skin 1080x1920 -no-window -no-boot-anim -no-audio -no-jni -gpu swiftshader_indirect -ranchu -qemu &>${LOG_DIR}/emulator-${ID}.log  &
done

for ID in 5554 5556 5558 5560 5562 5564 5566 5568
do
	if timeout 3m adb -s emulator-${ID} wait-for-device shell 'while [[ -z $(getprop dev.bootcomplete) ]]; do sleep 5; done;'; then
    echo "Device ${ID} is ready."
  else
    echo "Timed out waiting for device ${ID} to be ready."
    exit 1
  fi
	adb devices
	adb -s emulator-${ID} shell settings get global package_verifier_enable
	adb -s emulator-${ID} uninstall com.example.broker.beta --force >/dev/null || true
	adb -s emulator-${ID} shell 'echo "chrome --disable-fre --no-default-browser-check --no-first-run --ignore-certificate-errors" > /data/local/tmp/chrome-command-line'
  adb -s emulator-${ID} shell 'wm size 1080x2400'
  adb -s emulator-${ID} shell 'wm density 395'
done
date
