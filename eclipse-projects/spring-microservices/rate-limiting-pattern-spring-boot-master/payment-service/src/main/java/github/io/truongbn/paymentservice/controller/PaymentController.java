package github.io.truongbn.paymentservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.io.truongbn.paymentservice.model.Type;
import github.io.truongbn.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/payment-service")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping
    public Type submitPayment(@RequestBody String paymentInfo) {
        return paymentService.submitPayment(paymentInfo);
    }
}
