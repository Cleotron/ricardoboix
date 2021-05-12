package com.rboix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication //configuracion


public class RicardoboixApplication {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RicardoboixApplication.class, args);
	}
}
