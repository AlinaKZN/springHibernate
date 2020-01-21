package ru.spring.boot.hibernate.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	//http://localhost:8081/api/find - Показать все записи
	//http://localhost:8081/api/find/1 - Запись с id=1
	//http://localhost:8081/api/save/1 - Меняет имя записи с id=1 и сохраняет
	//http://localhost:8081/api/delete/1 - Удяляет запись с id=1


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
