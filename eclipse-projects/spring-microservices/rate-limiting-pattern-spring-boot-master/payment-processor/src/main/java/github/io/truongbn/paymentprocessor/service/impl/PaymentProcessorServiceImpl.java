package github.io.truongbn.paymentprocessor.service.impl;

import org.springframework.stereotype.Service;

import github.io.truongbn.paymentprocessor.service.PaymentProcessorService;

@Service
public class PaymentProcessorServiceImpl implements PaymentProcessorService {
    @Override
    public String processPayment(String paymentInfo) {
        // Simulated logic to process payment
        return "Payment processed: " + paymentInfo;
    }
}
