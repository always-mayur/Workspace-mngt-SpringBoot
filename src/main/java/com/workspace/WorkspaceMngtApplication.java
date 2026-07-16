package com.workspace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.workspace.mapper")
public class WorkspaceMngtApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkspaceMngtApplication.class, args);
	}

}

/*

./mvnw clean

./mvnw clean install
./mvnw spring-boot:run

*/
