pkill -9 -f "selenium-server"
pkill -9 -f "appium -p"
adb -s "emulator-5554" emu kill || true
