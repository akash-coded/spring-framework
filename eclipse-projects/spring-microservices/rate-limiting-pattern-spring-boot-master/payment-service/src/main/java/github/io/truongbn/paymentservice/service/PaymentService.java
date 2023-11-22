package github.io.truongbn.paymentservice.service;

import github.io.truongbn.paymentservice.model.Type;

public interface PaymentService {
    Type submitPayment(String paymentInfo);
}
