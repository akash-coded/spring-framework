package demo.microservices.messaging.patterns.claim.check.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.microservices.messaging.patterns.claim.check.service.MessageService;

@RestController
public class MessageController {

	private MessageService messageService;
	
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@PostMapping("/messages")
	public List<String> receiveMessage(@RequestBody String payload) {
		return messageService.createMessage(payload);
	}
	
	@GetMapping("/messages/{ids}")
	public ResponseEntity<?> getMessage(@PathVariable List<String> ids) {
		return ResponseEntity.ok(messageService.getMessage(ids));
	}
	
	// '/messages/id1,id2'
	
}
