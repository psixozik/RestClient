# RestClient
Simple example REST with Kafka - сервис работает в свзявке с DBService и ArticleClient

Необходимо поднять локальный брокер под Kafkу. Переопределить application.yml. Базовая реализация. 

POST -> api/user {
	"firstName" : "",
	"secondName" : "",
	"lastName" : "",
	"dateOfBirthDay" : "12.01.1995"
} = dateOfBirthDay строго по паттерну DD.MM.YYYY

GET -> api/user/{id} {указать ID клиента, как PrimartKey -> можно увидеть в логах DBService после регистрации}
