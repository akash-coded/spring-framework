package com.rest.loans.services;

import com.rest.loans.dtos.InterestRate;
import com.rest.loans.entities.Loan;
import com.rest.loans.repositories.LoanRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_NAME = "loan-service";

    private static final String RATE_SERVICE_URL = "http://localhost:9000/api/rates/";

    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "getDefaultLoans")
    public List<Loan> getAllLoansByType(String type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<InterestRate> entity = new HttpEntity<>(null, headers);
        ResponseEntity<InterestRate> response = restTemplate.exchange(
                (RATE_SERVICE_URL + type),
                HttpMethod.GET, entity,
                InterestRate.class);
        InterestRate rate = response.getBody();
        List<Loan> loanList = new ArrayList<>();
        if (rate != null) {
            loanList = loanRepository.findByType(type);
            for (Loan loan : loanList) {
                loan.setInterest(loan.getAmount() * (rate.getRateValue() / 100));
            }
        }
        return loanList;
    }

    public List<Loan> getDefaultLoans(String type, Exception e) {
        return new ArrayList<>();
    }
}
