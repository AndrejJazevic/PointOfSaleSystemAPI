package com.prada.prada.shift;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/Shift")
public class ShiftController {
	
	private Map<String, Shift> db = new HashMap<>(){{
		put("1", new Shift(1, 1, "2022-03-03", "2022-04-04"));
	}};
	
	@GetMapping("/")
	public Collection<Shift> getAllShifts(){
		return db.values();
	}
	
	@PutMapping("/{id}")
    public Shift modifyShift(@PathVariable String id, @RequestBody int employeeId, String startDate, String endDate) throws IOException {
        Shift shift = new Shift(Integer.valueOf(id), employeeId, startDate, endDate);
        db.put(String.valueOf(id), shift);
        return shift;
    }
}
