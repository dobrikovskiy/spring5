
### Запуск

После копирования с Github:

* Вначале для запуска базы PostgreSQL через Docker запускаем команду в терминале:
docker run --name postgresql-container \
           -e POSTGRES_DB=mynotes \
           -e POSTGRES_USER=mynotes \
           -e POSTGRES_PASSWORD=secret \
           -p 5432:5432 \
           -d postgres:13.2-alpine

или docker-compose build затем docker-compose up -d

* После запуска базы запускаем сайт через команду в терминале: ./mvnw spring-boot:run
