Animal Project

Этот проект представляет собой Java-приложение, реализующее модель животных с использованием принципов объектно-ориентированного программирования и инъекции зависимостей. Проект включает классы Animal, Feline, Cat, Lion и интерфейс Predator, а также тесты с использованием JUnit 4, Mockito и JaCoCo для обеспечения 100% покрытия кода.

Требования задания





Нейминг: Корректный нейминг элементов согласно Java-конвенциям.



Зависимости: В pom.xml подключены JaCoCo, Mockito и JUnit, без лишних зависимостей.



Расположение тестов: Тесты находятся в src/test/java.



Инъекция зависимостей: Класс Lion зависит от интерфейса Predator, а не от Feline.



Моки: Использованы моки с Mockito в тестах для Cat и Lion.



Параметризация: Параметризованные тесты для Feline и Lion вынесены в отдельные классы.



Покрытие кода: Классы Feline, Cat и Lion покрыты тестами на 100%, подтверждено отчетом JaCoCo.



Отчет JaCoCo: Сгенерирован и закоммичен в репозиторий.

Структура проекта

project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── Animal.java       # Базовый класс для животных
│   │   │       ├── Cat.java          # Класс кошки, зависит от Predator
│   │   │       ├── Feline.java       # Класс кошачьих, реализует Predator
│   │   │       ├── Lion.java         # Класс льва, зависит от Predator
│   │   │       ├── Predator.java     # Интерфейс для хищников
│   ├── test/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── FelineTest.java   # Обычные тесты для Feline
│   │   │       ├── FelineParameterizedTest.java # Параметризованные тесты для Feline
│   │   │       ├── CatTest.java      # Тесты для Cat
│   │   │       ├── LionTest.java     # Тесты для Lion
├── pom.xml                           # Файл конфигурации Maven
├── README.md                         # Документация проекта
├── target/
│   ├── site/
│   │   ├── jacoco/                   # Отчет JaCoCo

Зависимости





Java: 11 (настоятельно рекомендуется)



Maven: 3.6.0 или выше



Зависимости Maven:





JUnit 4.13.2 (тестирование)



Mockito Core 5.2.0 (моки)



Mockito Inline 5.2.0 (поддержка инлайн-моков)



JaCoCo 0.8.12 (покрытие кода)

Установка





Убедитесь, что установлена Java 11:

java -version

Если установлена другая версия (например, Java 23), установите Java 11 (например, OpenJDK 11 от Adoptium: https://adoptium.net/):





Windows: Установите JAVA_HOME (например, C:\Program Files\Eclipse Adoptium\jdk-11.0.21-hotspot) и добавьте %JAVA_HOME%\bin в PATH.



Перезапустите IntelliJ IDEA после изменения.



Убедитесь, что установлен Maven:

mvn --version



Склонируйте или распакуйте проект в локальную директорию:

C:\Users\Jlap4\yandex\proba\qa_java

Настройка IntelliJ IDEA





Откройте File > Project Structure > SDKs, добавьте JDK 11.



В Project Structure > Project, установите Project SDK на Java 11.



В Settings > Build, Execution, Deployment > Build Tools > Maven > Runner, установите JRE на Java 11.



Если зависимости подчёркнуты красным:





Нажмите File > Invalidate Caches / Restart.



Щёлкните правой кнопкой на pom.xml > Maven > Reload Project.

Сборка и запуск тестов





Перейдите в корень проекта:

cd C:\Users\Jlap4\yandex\proba\qa_java



Соберите проект и запустите тесты:

mvn clean test





clean: Удаляет предыдущие сборки.



test: Запускает все тесты в src/test/java.



Результаты тестов:





Консольный вывод покажет, сколько тестов выполнено, успешных/неуспешных.



Подробные логи: target/surefire-reports/.

Проверка покрытия кода





После выполнения mvn clean test отчет JaCoCo будет сгенерирован в:

target/site/jacoco/index.html



Откройте index.html в браузере, чтобы проверить покрытие.



Покрытие составляет 100% для классов Feline, Cat и Lion.

Для принудительной генерации отчета JaCoCo:

mvn clean test jacoco:report

Генерация и коммит отчета JaCoCo





Убедитесь, что проект находится под управлением Git:

git init

Если репозиторий уже создан, пропустите этот шаг.



Сгенерируйте отчет JaCoCo:

mvn clean test jacoco:report



Добавьте отчет в Git:

git add target/site/jacoco/*



Закоммитьте изменения:

git commit -m "Add JaCoCo coverage report"



Если нужно, отправьте изменения в удаленный репозиторий:

git push origin main

(Замените main на вашу ветку, если она отличается).

Запуск отдельного теста

Чтобы запустить только один тестовый класс, например, LionTest:

mvn test -Dtest=LionTest

Устранение неполадок





JaCoCo не генерирует отчет:





Проверьте наличие файла target/jacoco.exec. Если он отсутствует, выполните:

mvn clean test jacoco:report



Убедитесь, что используется Java 11, так как JaCoCo может быть нестабильным с Java 23.



Проверьте конфигурацию JaCoCo в pom.xml.



Зависимости подчёркнуты красным:





Убедитесь, что есть интернет-соединение.



Очистите локальный кэш Maven:

mvn dependency:purge-local-repository



В IntelliJ IDEA щёлкните правой кнопкой на pom.xml > Maven > Reload Project.



Перезапустите IntelliJ IDEA: File > Invalidate Caches / Restart.



Ошибка "Java 23 is not supported by Byte Buddy":





Убедитесь, что используется Java 11:

java -version



Если Java 23, установите Java 11 и настройте JAVA_HOME.



Ошибки компиляции:





Убедитесь, что используется Java 11.



Проверьте синтаксис всех файлов.



Тесты не проходят:





Проверьте логи в target/surefire-reports/.



Убедитесь, что моки в CatTest и LionTest настроены для интерфейса Predator.

Примечания





Классы Lion и Cat используют интерфейс Predator для инъекции зависимостей, что устраняет прямую зависимость от Feline.



Параметризованные тесты для Feline вынесены в FelineParameterizedTest.java, для Lion — в LionTest.java.



Java 11 предпочтительнее Java 23 для стабильной работы JaCoCo и Mockito.



Отчет JaCoCo подтверждает 100% покрытие кода для Feline, Cat и Lion.

Если у вас есть вопросы или нужна помощь, свяжитесь с разработчиком проекта.