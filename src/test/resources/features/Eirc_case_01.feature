#language:ru
@Eirc
Функционал: План тестов для прикладного компонента взаимодействия с Автоматизированной информационной системой «Электронная модель территориальной схемы обращения с отходами»

  Сценарий: Сценарий №1. Авторизация пользователя в ПУ ПИВ с правами доступа к ПКВ ТСОО

    * Открыть url "http://localhost:8092/login"
    * Инициализация страницы "ЕИРЦ страница входа"
    * Подождать появления элемента "Поле логина" в течение 180 секунд
    * Ввести в поле "Поле логина" значение "admin"
    * Ввести в поле "Поле пароля" значение "admin"
    * Кликнуть на элемент "Кнопка входа"
    * Подождать появления текста "Процесс" в течении 180 секунд