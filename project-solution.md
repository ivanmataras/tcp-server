# **Проектное решение**

## **Описание сущностей**

Описание бизнес сущностей реализовано в формате xsd схем в приложении к проектному решению.

* DocumentStatus.xsd
* DocumentType.xsd
* Message.xsd
* Orders.xsd
* Ordrsp.xsd
* Organization.xsd
* Organization.xsd
* Route.xsd
* User.xsd

## **Описание протокола**

Формат имени файла ГОД-МЕСЯЦ-ДАТА_ЧАС:МИНУТА:СЕКУНДА.zip

Протокол представляет из себя контейнер в виде каталога сжатого в формате zip. Каталог содержит 2 файла.

**meta.xml** файл содержит все метаданные сообщения.

Protocol-Type: имя протокола
Тип: строка
Значение по умолчанию: SXBP (simple xml based protocol)

Protocol-Version: версия протокола
Тип: число
Значение по умолчанию: 1

Method: метод
Тип: строка
Значение по умолчанию: нет
Принимаемые значения:

* FIND
* CREATE
* UPDATE
* DELETE
* CONNECT

URI: адрес ресурса
Тип: строка
Значение по умолчанию: нет
Принимаемые значения: Пространство имен вида имя сервера/имя сущности/уникальный идентификатор сущности (id)

Status-Code: код статуса
Тип: число
Значение по умолчанию: нет
Принимаемые значения:

* 2xx - запрос клиента успешно обработан
* 3xx - перенаправление запроса
* 4xx - ошибка клиента
* 5xx - ошибка сервера

Детальные коды будут добавлены в процессе разработки.

Reason-Phrase: код статуса
Тип: строка
Значение по умолчанию: нет
Принимаемые значения: текстовое описание кода

Server: имя сервера
Тип: строка
Значение по умолчанию: localhost
Принимаемые значения: имя сервера

Content-Encoding: кодировка содержимого
Тип: строка
Значение по умолчанию: UTF-8
Принимаемые значения: UTF-8

Content-Language: язык содержимого
Тип: строка
Значение по умолчанию: нет
Принимаемые значения: EN, RU

Content-Type: тип содержимого
Тип: строка
Значение по умолчанию: нет
Принимаемые значения: DocumentStatus, DocumentType, Orders, Ordrsp, Organization, Organization, Route, User

User-Agent: тип клиента
Тип: строка
Значение по умолчанию: SSC (simple swing client)
Принимаемые значения: SSC (simple swing client)

**content.xml** файл содержит передаваемые данные сообщения.
Возможные варианты сущностей описаны в схемах:

* DocumentStatus.xsd
* DocumentType.xsd
* Orders.xsd
* Ordrsp.xsd
* Organization.xsd
* Organization.xsd
* Route.xsd
* User.xsd

## **Описание взаимодействия**

Клиент отправляет запрос описанной структуры серверу. 
Сервер обрабатывает запрос и возвращает клиенту ответ. 