package com.springboot.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.cursomc.dao.AddressDAO;
import com.springboot.cursomc.dao.CategoryDAO;
import com.springboot.cursomc.dao.CityDAO;
import com.springboot.cursomc.dao.ClientDAO;
import com.springboot.cursomc.dao.ProductDAO;
import com.springboot.cursomc.dao.StateDAO;
import com.springboot.cursomc.entitys.Address;
import com.springboot.cursomc.entitys.Category;
import com.springboot.cursomc.entitys.City;
import com.springboot.cursomc.entitys.Client;
import com.springboot.cursomc.entitys.Product;
import com.springboot.cursomc.entitys.State;
import com.springboot.cursomc.entitys.enums.ClientType;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CityDAO cityDAO;
	
	@Autowired
	private StateDAO stateDAO;
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private ClientDAO clientDAO;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryDAO.saveAll(Arrays.asList(cat1, cat2)); 
		productDAO.saveAll(Arrays.asList(p1, p2, p3));
		
		State state1 = new State(null, "Minas Gerais");
		State state2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Uberlândia", state1);
		City c2 = new City(null, "São Paulo", state2);
		City c3 = new City(null, "Campinas", state2);
		
		state1.getCities().addAll(Arrays.asList(c1));
		state2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateDAO.saveAll(Arrays.asList(state1, state2));
		cityDAO.saveAll(Arrays.asList(c1, c2, c3));
		
		Client client1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PESSOAFISICA);
		
		client1.getPhones().addAll(Arrays.asList("27363323", "93838393"));
		
		Address a1 = new Address(null, "Rua Flores", "300", client1, c1);
		Address a2 = new Address(null, "Avenida Matos", "105", client1, c2);
		
		client1.getAddresses().addAll(Arrays.asList(a1, a2));
		
		clientDAO.saveAll(Arrays.asList(client1));
		addressDAO.saveAll(Arrays.asList(a1,a2));
		
		
	}


}
