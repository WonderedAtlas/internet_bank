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

![DBeaver_Screen](https://github.com/user-attachments/assets/4bdee852-5c7a-4629-a0c1-d214862f5595)





