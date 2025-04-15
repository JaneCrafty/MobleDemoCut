# Настройка окружения для проекта JMobile

Для работы необходимо совершить следующие шаги:

1. Open JDK 8 версии
2. Git
3. IDE: IntelliJ Idea Community Edition 
4. Maven
5. Android Studio
6. Xcode
7. Appium
8. Fork
9. Прописать в bash profile зависимости
10. Клонировать проекты iOS, Android и JMobile
11. Настроить окружения

### Установка JDK

Инструкция для установки Open JDK https://installvirtual.com/install-openjdk-8-on-mac-using-brew-adoptopenjdk/.

Для проверки Java и Javac необходимо:

1. Открыть терминал

2. Ввести поочередно команды

```
java -version
javac -version
```

Результатом выполнения команд является версия установленной Java
   
Если в результате была получена ошибка, вводим в консоли последовательно эти команды

```
/usr/libexec/java_home -V
```

```
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`
```

### Установка Git

Для установки git нужно ввести в терминале команду:

```
git --version
```

После этого система предложит установить его. 


### Установка IntelliJ IDEA

Для установки IDEA нужно:

1. Скачать на сайте jetbrains.com версию Community для Mac (https://www.jetbrains.com/idea/download/#section=mac)

2. Установить на компьютер

### Импортируем проект в IntelliJ IDEA  (делаем действия из туториала) 

https://github.com/devstarter/ii/wiki/%D0%9E%D1%82%D0%BA%D1%80%D1%8B%D1%82%D0%B8%D0%B5-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B0-%D0%B2-IntelliJ-IDEA

### Установка Maven

1. Установить HomeBrew. Для этого нужно ввести команду в терминале:

```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

2. Установить maven, введя команду в терминале:

```
brew install maven
```

3. Проверить установку командой:

```
mvn -version
```
### Установка Android Studio

1.  Зайти на сайт https://developer.android.com/studio/install
2.  Скачать dmg файл студии
3.  Запустить файл
4.  Перенести студию в Application folder и запустить
5.  Выбрать необходимую опцию импорта настроек (если нужно).
6.  Следовать командам установщика 


### Установка Xcode

1. Перейдите по этой ссылке в Mac App Store https://apps.apple.com/us/app/xcode/id497799835?mt=12
2. Наажать на View in Mac App Store
3. На открывшейся странице Xcode в App Store нажать на кнопку Free
4. Нажать на Install App.

### Установка Appium

#### Установка терминального Appium

1. Идем на https://nodejs.org/en/download/ скачиваем и устанавливаем Node package
2. Для проверки установки вводим команды в терминале


```
node -v Terminal.
```

```
npm -v Terminal.
```
3. Устанавливаем сам Appium введя в терминале

```
npm install -g appium@1.17.1
```
где @1.17.1 - версия appium на нашем CI (актуальную уточнять!)
Если встречаемся с ошибками типа 

```
npm WARN checkPermissions Missing write access to /usr/local/lib/node_modules
npm ERR! code EACCES
npm ERR! syscall access
npm ERR! path /usr/local/lib/node_modules
npm ERR! errno -13
npm ERR! Error: EACCES: permission denied, access '/usr/local/lib/node_modules'
npm ERR!  [Error: EACCES: permission denied, access '/usr/local/lib/node_modules'] {
npm ERR!   stack: "Error: EACCES: permission denied, access '/usr/local/lib/node_modules'",
npm ERR!   errno: -13,
npm ERR!   code: 'EACCES',
npm ERR!   syscall: 'access',
npm ERR!   path: '/usr/local/lib/node_modules'
npm ERR! }
npm ERR! 
npm ERR! The operation was rejected by your operating system.
npm ERR! It is likely you do not have the permissions to access this file as the current user
npm ERR! 
npm ERR! If you believe this might be a permissions issue, please double-check the
npm ERR! permissions of the file and its containing directories, or try running
npm ERR! the command again as root/Administrator.
```

То фиксим их командами 

```
id -un # Даёт твой user name (Который добавим в поле owner)
 
sudo chown -R [owner] /usr/local/lib/node_modules
```

#### Установка десктопного Appium

1. Скачать на github версию аппиума для Mac (https://github.com/appium/appium-desktop/releases/tag/v1.17.1-1)

2. Установить 

### Установка Fork

Скачать версию Fork для Mac с официального сайта git-fork.com и установить

### Прописать переменные среды в zsh профайл 

Добавляем переменные среды (обратить внимание на указание корректного <USER NAME> и <YOUR VERSION JVM>)

1. Свою версию JVM узнаем с помощью 

```
javac -version
```
2. Дальше последовательно вводим

```
echo 'export JAVA_HOME=/Library/Java/JavaVirtualMachines/ <YOUR VERSION JVM> /Contents/Home' >> ~/.zshenv
echo 'export ANDROID_HOME=/Users/ <USER NAME> /Library/Android/sdk' >> ~/.zshenv
echo 'export ANDROID_SDK_ROOT=${ANDROID_HOME}' >> ~/.zshenv
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.zshenv
echo 'export PATH=$ANDROID_HOME/tools:$PATH' >> ~/.zshenv
echo 'export PATH=$ANDROID_HOME/tools/bin:$PATH' >> ~/.zshenv
echo 'export PATH=$ANDROID_HOME/platform-tools:$PATH' >> ~/.zshenv
echo 'export PATH=$ANDROID_HOME//emulator:$PATH' >> ~/.zshenv
```
Или сразу открываем .zshenv, прописываем туда все переменные и сохраняем

```
open ~/.zshenv

export JAVA_HOME=/Library/Java/JavaVirtualMachines/ <YOUR VERSION JVM> /Contents/Home
export ...
```

### Клонировать проекты iOS, Android и JMobile

Preconditions

Локально структура проектов должна быть такой: внутри JMobile лежат проекты ios и android (необходимо для корректного поиска пути приложения при запуске тестов).
Должны быть доступы к репозиториям iOS, Scichart, Android 

1.  Заходим директорию нужного проекта
2.  В правом верхнем углу жмем clone
3.  Выбираем SSH
4.  Вводим последовательно следующие команды

```
git init
git clone https://gitlab.example.com/qamain/JMobile JMobile
git clone git@gitlab.example.com:mobile/ios/example.git ios
git clone git@gitlab.example.com:mobile/android/example.git android
```

### Установка Chrome driver

Для работы тестов, связанных с кассой необходимо:

1.  Скачать chrome driver для мака версии 2.44 (https://chromedriver.storage.googleapis.com/index.html?path=2.44/)

2.  Положить разархивированный хромдрайвер в корень проекта JMobile

## Сборка проекта Android

Для сборки нужно:

1. Перейти в терминале в склонированный проект android

2. Набрать git status и убедиться, что находишься на ветке master

3. Спулить деволоп командой 

```
git pull
```

4. Набрать команду 

```
./gradlew clean assembleBrokerBetaRelease -PdockerName="release-m"
```

В случае, если сборка будет падать с такой ошибкой
```
Warning: License for package Android SDK Build-Tools 28.0.3 not accepted.
FAILURE: Build failed with an exception.
```
Нужно зайти в Android Studio - Tools - SDK Manager и установить нужную версию API

## Настройка окружения для Android

### Настройка эмулятора

1. Открыть Android Studio
2. Открыть AVD 
3. Нажать Create Virtual Device
4. Выбрать необходимый эмулятор
5. Выбрать нужную версию Api

#### Или
`` avdmanager create avd -f -n android-5554 -k "system-images;android-30;google_apis;x86_64" -d "Nexus 5"; done``

### Локальный запуск скриптами
1. запустить ./scripts/startAndroidEmulatorLocal.command - запускает селениум, аппиум и эмулятор
2. чтобы прекратить работу селениума и аппиума запустить ./scripts/stopAndroidEmulatorLocal.command

Скрипт запуска предполагает наличие файлов
``~/grid/selenium-server-4.1.1.jar``
и
`` ~/grid/appium_config.toml``

Запускаться должно двойным кликом

При первом запуске - правой клавишей и из меню выбрать Open

Чтобы выдать права на запуск выполнить в терминале команды

``chmod +x ./scripts/startAndroidEmulatorLocal.command``

``chmod +x ./scripts/stopAndroidEmulatorLocal.command``

### Отключение анимации

1.  Открыть нужный эмулятор
2.  Активировать инструменты разработчика (Options -> System -> About emulated device) 6 раз кликнуть по Build number 
3.  Перейти в Developer options (Options -> System -> Devloper options)
4.  В разделе Drawings Перевести в положение Off Window animation scale, Transition animation scale и Animator duration scale

### Установка Chrome Driver (Нужен для тестов, которые затрагивают кассу)

1.  Скачиваем версию 2.44
2.  Открываем десктопный Appium
3.  Выбираем вкладку Advanced
4.  В поле Chromedriver Binary Path вставляем путь до хромдрайвера
5.  Жмем сохранить как пресет
6.  Далее ставим хромдрайвер для терминального Appium
7.  Открываем консоль и пишем команду

 ```
CHROMEDRIVER_VERSION=2.44 npm install appium
 ```
 
### Original error: Could not find adb Please set the ANDROID_HOME environment variable with the Android SDK root directory path
 
 Для решения подобной ошибки при запуске тестов можно попробовать отредактировать конфигурацию Appium. Для этого нужно:
 
 1. Запустить Appium
 
 2. Зайти в редактирование конфигурации
 
 3. В поле ANDROID_HOME ввести /Users/a.lebedkova/Library/Android/sdk
 
 4. В поле JAVA_HOME - /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home
 
 5. Сохранить и перезапустить аппиум
 
### Установка сертификатов на эмулятор

https://conf.karuna.group/pages/viewpage.action?pageId=33195099

## Сборка проекта IOS

Для сборки нужно:

1. Перейти в терминале в склонированный проект ios

2. Набрать git status и убедиться, что находишься на ветке develop

3. Спулить деволоп командой 

```
git pull
```

4. Набрать команду 

```
git stash & git pull & git update & git submodule init && git submodule update && pod repo update && pod install && xcodebuild -workspace example.xcworkspace -scheme example-Beta -configuration Debug -sdk iphonesimulator  SYMROOT=${PWD}/app clean build
```

## Настройка окружения для iOS

### Установка Cocoa Pods 

Прописываем в терминале следующую команду

```
$ sudo gem install cocoapods
```

### Установка Carthage 

Устанавливаем через brew

```
brew install carthage
```

### Установка сертификатов на эмулятор

https://conf.karuna.group/pages/viewpage.action?pageId=33195099

### Первый запуск тестов

При первом запуске тестов для ios может появиться ошибка:

```
org.openqa.selenium.SessionNotCreatedException: Unable to create a new remote session. Please check the server log for more details. Original error: An unknown server-side error occurred while processing the command. Original error: Unable to launch WebDriverAgent because of xcodebuild failure: xcodebuild failed with code 65
```

Для решения этой ошибки нужно:

1. В запущенном аппиуме нажать на лупу

2. В открывшемся окне в разделе Desired Capabilities в окне JSON Representation нажать кнопку редактирования 

3. Вставить строки из https://conf.karuna.group/display/QA/Appium+IOS+Settings 

4. Изменить строки platformVersion и deviceName на соответствующие нашему симулятору

5. В значение строки app вставить путь до example-Beta.app в проекте ios 

6. Save as. Значения сохранятся как пресет


### Прокси для тестирования на проде

Чтобы на ci запускались тесты с прокси, нужно выставить переменную USE_PROXY в true
Настройки прокси хранятся в переменной PROXY_CONNECTION_STRING гитлаба
Прокси для индии, внутренни сервисы для нее недоступны
