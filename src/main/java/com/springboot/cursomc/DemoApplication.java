package com.springboot.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.cursomc.dao.AddressDAO;
import com.springboot.cursomc.dao.CategoryDAO;
import com.springboot.cursomc.dao.CityDAO;
import com.springboot.cursomc.dao.ClientDAO;
import com.springboot.cursomc.dao.PackageDAO;
import com.springboot.cursomc.dao.PaymentDAO;
import com.springboot.cursomc.dao.ProductDAO;
import com.springboot.cursomc.dao.StateDAO;
import com.springboot.cursomc.entitys.Address;
import com.springboot.cursomc.entitys.CardPayment;
import com.springboot.cursomc.entitys.Category;
import com.springboot.cursomc.entitys.City;
import com.springboot.cursomc.entitys.Client;
import com.springboot.cursomc.entitys.Package;
import com.springboot.cursomc.entitys.Payment;
import com.springboot.cursomc.entitys.Product;
import com.springboot.cursomc.entitys.State;
import com.springboot.cursomc.entitys.TicketPayment;
import com.springboot.cursomc.entitys.enums.ClientType;
import com.springboot.cursomc.entitys.enums.PaymentStatus;

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
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@Autowired
	private PackageDAO orderDAO;

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
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Package order1 = new Package(null, sdf.parse("30/09/2017 10:32"), client1, a1);
		Package order2 = new Package(null, sdf.parse("10/10/2017 19:35"), client1, a2);
		
		Payment payment1 = new CardPayment(null, PaymentStatus.PAID, order1, 6);
		order1.setPayment(payment1);
		
		Payment payment2 = new TicketPayment(null, PaymentStatus.PENDING, order2, sdf.parse("20/10/2017 00:00"), null);
		order2.setPayment(payment2);
		
		client1.getOrders().addAll(Arrays.asList(order1, order2));
		
		orderDAO.saveAll(Arrays.asList(order1, order2));
		paymentDAO.saveAll(Arrays.asList(payment1, payment2));
		
	}


}
