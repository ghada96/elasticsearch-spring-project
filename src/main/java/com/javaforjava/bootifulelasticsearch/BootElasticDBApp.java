package com.javaforjava.bootifulelasticsearch;

import com.javaforjava.bootifulelasticsearch.dal.UserDAL;
import com.javaforjava.bootifulelasticsearch.dal.UserRepository;
import com.javaforjava.bootifulelasticsearch.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;

@SpringBootApplication
public class BootElasticDBApp {
	UserDAL user;

	public static void main(String[] args) {
		SpringApplication.run(BootElasticDBApp.class, args);
	}

	/*@Override
	public void run(String... strings) throws Exception {
		user.addNewUser(new User("1","ghada",new Date(),new HashMap<>()));
		user.addNewUser(new User("2","amri",new Date(),new HashMap<>()));


	}*/
}
