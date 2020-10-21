package com.springboot.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.cursomc.dao.CategoryDAO;
import com.springboot.cursomc.entity.Category;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryDAO categoryDAO;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(1, "Computing");
		Category cat2 = new Category(2, "Office");
		
		categoryDAO.saveAll(Arrays.asList(cat1, cat2)); 
	}

}
