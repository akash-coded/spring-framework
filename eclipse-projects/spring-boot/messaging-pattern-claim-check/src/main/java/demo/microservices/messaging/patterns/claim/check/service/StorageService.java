package demo.microservices.messaging.patterns.claim.check.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class StorageService {
	private static Long payloadId = 1L;
	
	private Map<Long, String> payloadDataStore = new HashMap<>();
	private Map<String, Long> claimDataStore = new HashMap<>();
	
	public String save(String payload) {
		payloadDataStore.put(payloadId, payload);
		
		String claimId = UUID.randomUUID().toString();
		claimDataStore.put(claimId, payloadId++);
		
		return claimId;
	}
	
	public String retrieve(String claimId) {
		Long claim = claimDataStore.get(claimId);
		String payloadChunk = payloadDataStore.get(claim);
		
		return payloadChunk;
	}
	
}
