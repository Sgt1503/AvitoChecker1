# AvitoChecker1
Для того чтобы запустить проект потребуется:
1. Android Studio + Android SDK https://developer.android.com/studio
2. Дальше можно использовать либо эмулятор встроенный в Android Studio - AVD, не самый быстрый вариант зато сразу готовый мост ADB + иногда APK авито не устанавливается с первого раза (В полне возможно потому что у меня только 8 гб оперативки)
Либо реальное устройство https://you--hands-ru.turbopages.org/you-hands.ru/s/2019/11/08/kak-vklyuchit-i-polzovatsya-adb/
Либо как удобный вариант NOX player - https://www.bignox.com/
3. После установки Android Studio проверить PATH
4. Рекомендую запускать через NOX
(Его подключение к ADB https://www.bignox.com/blog/how-to-connect-android-studio-with-nox-app-player-for-android-development-and-debug/)
5. Установка APK на Nox https://ibb.co/n73S7G9
Ссылка на apk https://yadi.sk/d/SxdXJc56q1m9Uw
6. Запустить Android Studio настроить первый запуск и выбрать 
7. https://ibb.co/wQqbLLL
8. Склонировать репозиторий и ждать
9. В самом низу есть кнопка Build
10. Дождаться пока Gradle соберет проект
11. Нажать эту кнопку 
https://ibb.co/9bvFK8j
12. Нажать edit, если кнопка не активна, значит сборщик проекта Gradle не завершил процесс
https://ibb.co/rpj0pXx
13. Дальше по инструкции
14. 2 раза повторить это действие:
https://ibb.co/gVNyyxk

15. https://ibb.co/1nLfWww
16. https://ibb.co/gTZJNqx
17. https://ibb.co/1Q9ZKKS
18. https://ibb.co/5c2WYzs
19. В выпавшем окне выбрать test
Дальше нажать apply и ok
20. Проверить еще раз подключение к adb командой 
adb connect 127.0.0.1.62001
21. Желательно переставить эмулятор в вертикальное положение
22. https://ibb.co/0Cdd7nX
  1. Выбрать конфигурацию которую мы сделали до этого пункта
  2. Выбрать эмулятор(его название можно посмотреть в настройках Nox)
23. Нажать shift+f10
24. Открыть эмулятор и наблюдать
25. После завершения работы скрипта Json можно найти в терминале LogCat
26. Зайти https://ibb.co/wJV0gks
27. Нажать ctrl+f и ввести в поиск I/System 
Одна из строк и будет json'ом.

ОСОБОЕ ВНИМАНИЕ 
1. первому запуску, он холодный, скрипт может не сработать, все последующие запуски показали работоспособность
2. В java файле отметил, что не делал проверку вводимого логина, предполагается что вводимые данные уже будут чистыми, т.е. вида 89123456789 или mail@mail.xyz
