package com.example.demo;

import com.example.demo.user.dataaccess.repo.User;
import com.example.demo.user.dataaccess.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Time;

@SpringBootApplication()
//@EnableConfigurationProperties
//@EntityScan(basePackages = {"com.example.demo"})
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
//@ComponentScan(basePackages = {"com.example.demo"})
public class DemoApplication {
	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		

	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		User user=new User( "username",  "firstname",  "lastname",  "email",  "password",  "phone");
//		userRepository.save(user);
//		userRepository.findAll().forEach(System.out::println);
//	}
}
