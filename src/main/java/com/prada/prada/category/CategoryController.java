package com.prada.prada.category;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/Category")
public class CategoryController {
	
	private Map<String, Category> db = new HashMap<>(){{
		put("1", new Category(1, "name", "desc", 20));
	}};
	
	public Collection<Category> getAllCategories(){
		return db.values();
	}
	
	@PostMapping("/")
    public Category createCategory(@RequestBody String name, String description, int discount) throws IOException {
        int id = getAllCategories().size() + 1;
        Category category = new Category(id, name, description, discount);
        db.put(String.valueOf(id), category);
        return category;
    }
	
}
