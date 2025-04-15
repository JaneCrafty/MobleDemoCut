pkill -15 -f "appium -p"
pkill -15 -f "selenium-server"
pkill -15 -f emulator
sleep 10
adb devices | tail -n +2 | cut -sf 1 | xargs -I {} adb -s {} emu kill || true
adb kill-server

pkill -9 -f "appium -p"
pkill -9 -f "selenium-server"
pkill -9 -f chromedriver