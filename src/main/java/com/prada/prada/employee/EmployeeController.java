package com.prada.prada.employee;

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
@RequestMapping("api/Employee")
public class EmployeeController {
	
	private Map<String, Employee> db = new HashMap<>(){{
		put("1", new Employee(1, "name", "surname", "a.a@mail.com", "10"));
	}};
	
	@GetMapping("/")
	public Collection<Employee> getAllEmployees(){
		return db.values();
	}
	
	@GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
		Employee employee = db.get(id);
        if (employee == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return employee;
    }
	
	@GetMapping("employeeCardCode/{employeeCardCode}")
    public Employee getEmployeeByCardCode(@PathVariable String employeeCardCode) {
        Employee employee = db.get("a");
        for (String i : db.keySet()) {
            if(db.get(i).getEmployeeCardCode().equals(employeeCardCode))
                return db.get(i);
        }
        if (employee == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return employee;
    }
	
	@DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable String id) {
		Employee employee = db.remove(id);
        if (employee == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
	
	@PostMapping("/")
    public Employee createEmployee(@RequestBody String name, String lastname, String email, String employeeCardCode) throws IOException {
        int id = getAllEmployees().size() + 1;
        Employee employee = new Employee(id, name, lastname, email, employeeCardCode);
        db.put(String.valueOf(id), employee);
        return employee;
    }
	
	@PutMapping("/{id}")
    public Employee modifyEmployee(@PathVariable String id, @RequestBody String name, String lastname, String email, String employeeCardCode) throws IOException {
		Employee employee = new Employee(Integer.valueOf(id), name, lastname, email, employeeCardCode);
        db.put(String.valueOf(id), employee);
        return employee;
    }
}
