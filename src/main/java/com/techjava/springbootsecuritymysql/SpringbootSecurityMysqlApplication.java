package com.techjava.springbootsecuritymysql;

import com.techjava.springbootsecuritymysql.model.Role;
import com.techjava.springbootsecuritymysql.model.Users;
import com.techjava.springbootsecuritymysql.repository.RoleRepository;
import com.techjava.springbootsecuritymysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringbootSecurityMysqlApplication implements ApplicationRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityMysqlApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Role role1 = new Role();
		role1.setRole("ADMIN");
		roleRepository.save(role1);

		Set<Role> roles = new HashSet<>();
		roles.add(role1);

		Users user1 = new Users();
		user1.setPassword("password");
		user1.setUsername("username");
		user1.setRoles(roles);
		userRepository.save(user1);

	}
}
