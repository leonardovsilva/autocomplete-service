package com.leonardovsilva.autocomplete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class AutoCompleteController {

	@Autowired
	private EventCollectedService eventService;
	
	@HystrixCommand(fallbackMethod="addEventFallback")
	@PostMapping(path = "/event", consumes = "application/json", produces = "application/json")
	ResponseEntity<String> addEvent(@RequestBody EventCollected event) {
		
		eventService.save(event);
		return new ResponseEntity<>("Event saved.", HttpStatus.OK);

	}
	
	@HystrixCommand(fallbackMethod="autoCompleteFallback")
	@GetMapping(path = "/autocomplete", produces = "application/json")
	ResponseEntity<Page<EventCollected>> autoComplete(@RequestParam String word, @RequestParam int size) {
		
		Pageable pageElements = PageRequest.of(0, size);
		
		Page<EventCollected> events = eventService.findByEvent(word, pageElements);
        
		return new ResponseEntity<>(events, HttpStatus.OK);

	}
	
	@SuppressWarnings("unused")
	private ResponseEntity<String> addEventFallback() {
		
		return new ResponseEntity<>("Service unavaible.", HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@SuppressWarnings("unused")
	private ResponseEntity<String> autoCompleteFallback(@RequestParam String word, @RequestParam int size) {
		
		return new ResponseEntity<>("Service unavaible.", HttpStatus.SERVICE_UNAVAILABLE);
	}
}
