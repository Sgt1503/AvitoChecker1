# AvitoChecker1
Для того чтобы запустить проект потребуется:
Android Studio + Android SDK https://developer.android.com/studio
Дальше можно использовать либо эмулятор встроенный в Android Studio - AVD, не самый быстрый вариант зато сразу готовый мост ADB + иногда APK авито не устанавливается с первого раза (В полне возможно потому что у меня только 8 гб оперативки)
Либо реальное устройство https://you--hands-ru.turbopages.org/you-hands.ru/s/2019/11/08/kak-vklyuchit-i-polzovatsya-adb/
Либо как удобный вариант NOX player - https://www.bignox.com/
После установки Android Studio проверить PATH
Рекомендую запускать через NOX
(Его подключение к ADB https://www.bignox.com/blog/how-to-connect-android-studio-with-nox-app-player-for-android-development-and-debug/)
Установка APK на Nox https://ibb.co/n73S7G9
Ссылка на apk https://yadi.sk/d/SxdXJc56q1m9Uw
Запустить Android Studio настроить первый запуск и выбрать 
https://ibb.co/wQqbLLL
Склонировать репозиторий и ждать
В самом низу есть кнопка Build
Дождаться пока Gradle соберет проект
Нажать эту кнопку 
https://ibb.co/9bvFK8j
Нажать edit, если кнопка не активна, значит сборщик проекта Gradle не завершил процесс
https://ibb.co/rpj0pXx
Дальше по инструкции
2 раза повторить это действие:
https://ibb.co/gVNyyxk

https://ibb.co/1nLfWww
https://ibb.co/gTZJNqx
https://ibb.co/1Q9ZKKS
https://ibb.co/5c2WYzs
В выпавшем окне выбрать test
Дальше нажать apply и ok
Проверить еще раз подключение к adb командой 
adb connect 127.0.0.1.62001
Желательно переставить эмулятор в вертикальное положение
https://ibb.co/0Cdd7nX
1. Выбрать конфигурацию которую мы сделали до этого пункта
2. Выбрать эмулятор(его название можно посмотреть в настройках Nox)
Нажать shift+f10
Открыть эмулятор и наблюдать
После завершения работы скрипта Json можно найти в терминале LogCat
Зайти https://ibb.co/wJV0gks
Нажать ctrl+f и ввести в поиск I/System 
Одна из строк и будет json'ом.

ОСОБОЕ ВНИМАНИЕ 
1. первому запуску, он холодный, скрипт может не сработать, все последующие запуски показали работоспособность
2. В java файле отметил, что не делал проверку вводимого логина, предполагается что вводимые данные уже будут чистыми, т.е. вида 89123456789 или mail@mail.xyz
