package com.prada.prada.customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/Customer")
public class CustomerController {

	private Map<String, Customer> db = new HashMap<>(){{
		put("1", new Customer(1, "name", "lastname", "aaaa@mail.com", "pass", "address"));
	}};
	
	@GetMapping("/")
	public Collection<Customer> getAllCustomers(){
		return db.values();
	}
}
