package demo.microservices.messaging.patterns.claim.check.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

	private final StorageService storageService;
	
	public MessageService(StorageService storageService) {
		this.storageService = storageService;
	}
	
	private List<String> splitMessageIntoChunks(String message) {
		List<String> chunks = new ArrayList<>();
		int index = 0;
		int chunkSize = 100;
		
		while (index < message.length()) {
			chunks.add(message.substring(index, Math.min(index + chunkSize, message.length())));
			index += chunkSize;
		}
		
		return chunks;
	}
	
	public List<String> createMessage(String payload) {
		List<String> chunks = splitMessageIntoChunks(payload);
		List<String> claimIds = new ArrayList<>();
		
		for (String chunk: chunks) {
			String claimId = storageService.save(chunk);
			
			claimIds.add(claimId);
		}
		
		return claimIds;
	}
	
	public List<String> getMessage(List<String> claimIds) {
		List<String> payload = new ArrayList<>();
		
		for (String claimId: claimIds) {
			payload.add(storageService.retrieve(claimId));
		}
		
		return payload;
	}
}
