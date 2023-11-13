#language:ru
@Eirc
Функционал: План тестов для прикладного компонента взаимодействия с Автоматизированной информационной системой «Электронная модель территориальной схемы обращения с отходами»

  Сценарий: Сценарий №4. Запуск операций в рамках целевого процесса

    * Открыть url "http://localhost:8092/login"
    * Инициализация страницы "ЕИРЦ страница входа"
    * Подождать появления элемента "Поле логина" в течение 180 секунд
    * Ввести в поле "Поле логина" значение "admin"
    * Ввести в поле "Поле пароля" значение "admin"
    * Кликнуть на элемент "Кнопка входа"
    * Инициализация страницы "Главная страница"
    * Подождать появления элемента "Журнал процессов" в течение 180 секунд
    * Кликнуть на элемент "Журнал процессов"
    * Подождать появления элемента "Первый найденный процесс" в течение 180 секунд
    * Кликнуть на элемент "Ид.ОЖП первого процесса"
    * Инициализация страницы "Страница процесса"
    * Подождать появления элемента "Сводка процесса" в течение 180 секунд
    * Кликнуть на элемент "Сводка процесса"
    * Кликнуть на элемент "Кнопка 'Запустить' для операции процесса"
    * Ввести в поле "'startScanFrom' для операции процесса" значение "1690886209"
    * Ввести в поле "'endScanTo' для операции процесса" значение "1693564609"
    * Кликнуть на элемент "Кнопка подтверждения запуска для операции процесса"
    * Кликнуть на элемент "Кнопка 'OK' для успешно запущенной операции процесса"
    * Текст элемента "Статус операции процесса" равен: "В работе"