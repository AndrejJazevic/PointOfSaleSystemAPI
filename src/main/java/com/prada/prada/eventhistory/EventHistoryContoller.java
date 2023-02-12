package com.prada.prada.eventhistory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("api/EventHistory")
public class EventHistoryContoller {
	
	private Map<String, EventHistory> db = new HashMap<>(){{
		put("1", new EventHistory(1, "2022-12-23", "info", 1));
	}};
	
	@GetMapping("/")
	public Collection<EventHistory> getAllEventHistories(){
		return db.values();
	}
	
	@GetMapping("/{id}")
    public EventHistory getEventHistoryById(@PathVariable String id) {
		EventHistory eventHistory = db.get(id);
        if (eventHistory == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return eventHistory;
    }
	
}
