# Internet Bank REST API

REST API на Java Spring для работы с банковским счётом с использованием базы данных PostgreSQL.

## Описание

Проект предоставляет API для управления банковскими счетами:
- Просмотр баланса
- Пополнение счета
- Снятие средств

API построено на Spring Boot с использованием Spring Data JPA для взаимодействия с PostgreSQL.

### Операции

1. getBalance

Описание:
Отправка GET-запроса для получения текующего баланса пользователя

URL:
http://localhost:8080/api/getBalance/{user_id}

где:
{user_id} — идентификатор пользователя.

2. takeMoney

Описание:
Отправка POST-запроса для снятия суммы с баланса пользователя.

URL:
http://localhost:8080/api/takeMoney/{user_id}?amount={amount}

где:
{user_id} — идентификатор пользователя.
{amount} — сумма, которую нужно снять.

3. putMoney

Описание:
Отправка POST-запроса для пополнения баланса пользователя на указанную сумму.

URL:
http://localhost:8080/api/putMoney/{user_id}?amount={amount}

где:
{user_id} — идентификатор пользователя.
{amount} — сумма, которую нужно положить на счёт.

! При каждом вызове takeMoney и putMoney в таблицу со списком операций добавляется новое значение.

4. getOperationList

Описание:
Отправка GET-запроса для получения списка операций за выбранный диапазон времени.
Функция принимает ID пользователя и 2 даты и возвращает список операций за выбранный диапазон времени.
Если одно или оба значения диапазона дат являются пустыми, функция будет выдавать все операции без фильтрации по дате.

URL:
http://localhost:8080/api/getOperationList/{user_id}?startDate={startDate}&endDate={startDate}

где:
{user_id} — идентификатор пользователя.
{startDate} — начальная дата (формат yyyy-MM-dd HH:mm:ss)
{endDate} — конечная дата (формат yyyy-MM-dd HH:mm:ss)
   

![DBeaver_Screen](https://github.com/user-attachments/assets/4bdee852-5c7a-4629-a0c1-d214862f5595)
![operatios_data](https://github.com/user-attachments/assets/dc4f9d5c-af30-4903-bc98-86b459befbb4)
![operatios_data_2](https://github.com/user-attachments/assets/1709e204-e933-4ecd-8950-929640060cb5)










