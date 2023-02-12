package com.prada.prada.order;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("api/Order")
public class OrderController {
	private Map<String, Order> db = new HashMap<>(){{
		put("1", new Order(1, 1, "2022-01-01", "2022-02-02", 10, 1, 1));
	}};
	
	@GetMapping("/")
	public Collection<Order> getAllOrders(){
		return db.values();
	}
	
	@GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
		Order order = db.get(id);
        if (order == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return order;
    }
	
	@DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable String id) {
		Order order = db.remove(id);
        if (order == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
	
	@PostMapping("/")
    public Order createOrder(@RequestBody int status, String creationDate, String complitionDate, int discount, int customerId, int employeeId) throws IOException {
        int id = getAllOrders().size() + 1;
        Order order = new Order(id, status, creationDate, complitionDate, discount, customerId, employeeId);
        db.put(String.valueOf(id), order);
        return order;
    }
	
	@PutMapping("/{id}")
    public Order modifyOrder(@PathVariable String id, @RequestBody int status, String creationDate, String complitionDate, int discount, int customerId, int employeeId) throws IOException {
		Order order = new Order(Integer.valueOf(id), status, creationDate, complitionDate, discount, customerId, employeeId);
        db.put(String.valueOf(id), order);
        return order;
    }
}
