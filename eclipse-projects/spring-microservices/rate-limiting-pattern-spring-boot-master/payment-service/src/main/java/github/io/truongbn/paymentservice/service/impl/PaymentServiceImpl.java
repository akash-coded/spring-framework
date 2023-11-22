package github.io.truongbn.paymentservice.service.impl;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import github.io.truongbn.paymentservice.model.Failure;
import github.io.truongbn.paymentservice.model.Success;
import github.io.truongbn.paymentservice.model.Type;
import github.io.truongbn.paymentservice.service.PaymentService;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final RestTemplate restTemplate;
    private static final String SERVICE_NAME = "payment-service";
    private static final String PAYMENT_PROCESSOR_URL = "http://localhost:1010/api/v1/processor-payment";
    @RateLimiter(name = SERVICE_NAME, fallbackMethod = "fallbackMethod")
    public Type submitPayment(String paymentInfo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(paymentInfo, headers);
        ResponseEntity<String> response = restTemplate.exchange(PAYMENT_PROCESSOR_URL,
                HttpMethod.POST, entity, String.class);
        Success success = new Success(response.getBody());
        return success;
    }

    private Type fallbackMethod(RequestNotPermitted requestNotPermitted) {
        return new Failure("Payment service does not permit further calls");
    }
}
