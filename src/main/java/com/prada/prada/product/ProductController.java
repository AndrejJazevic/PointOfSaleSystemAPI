package com.prada.prada.product;

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
@RequestMapping("api/Product")
public class ProductController {
	
	private Map<String, Product> db = new HashMap<>(){{
		put("1", new Product(1, "name", "desc", 10, 1, "code", 1, 1));
	}};
	
	@GetMapping("/")
	public Collection<Product> getAllProducts(){
		return db.values();
	}
	
	@GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
		Product product = db.get(id);
        if (product == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return product;
    }
	
	@DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable String id) {
		Product product = db.remove(id);
        if (product == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
	
	@PostMapping("/")
    public Product createProduct(@RequestBody String name, String description, int price, int stock, String barcode, int category, int discount) throws IOException {
        int id = getAllProducts().size() + 1;
        Product product = new Product(id, name, description, price, stock, barcode, category, discount);
        db.put(String.valueOf(id), product);
        return product;
    }
	
	@PutMapping("/{id}")
    public Product modifyProduct(@PathVariable String id, @RequestBody String name, String description, int price, int stock, String barcode, int category, int discount) throws IOException {
		Product product = new Product(Integer.valueOf(id), name, description, price, stock, barcode, category, discount);
        db.put(String.valueOf(id), product);
        return product;
    }
}
