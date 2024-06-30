package com.jrmusics.JRMusics;

import com.jrmusics.JRMusics.principal.Main;
import com.jrmusics.JRMusics.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JrMusicsApplication implements CommandLineRunner {
	@Autowired
	private ArtistRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JrMusicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Main main = new Main(repository);
		main.showMenu();
	}
}
