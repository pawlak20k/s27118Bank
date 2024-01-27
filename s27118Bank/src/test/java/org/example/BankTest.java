package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class BankTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDepositEndpoint1() {
        restTemplate.postForEntity("/bank/register?id=1&balance=150.0", null, Void.class);

        ResponseEntity<ResponseTransaction> response = restTemplate.postForEntity("/bank/deposit?customerId=1&amount=150.0", null, ResponseTransaction.class);

        assertEquals(StatusTransaction.ACCEPTED, response.getBody().getStatus());
        assertEquals(150.0, response.getBody().getNewBalance());
    }
    @Test
    public void testDepositEndpoint2() {
        restTemplate.postForEntity("/bank/register?id=1&balance=100.0", null, Void.class);

        ResponseEntity<ResponseTransaction> response = restTemplate.postForEntity("/bank/deposit?customerId=1&amount=150.0", null, ResponseTransaction.class);

        assertEquals(StatusTransaction.ACCEPTED, response.getBody().getStatus());
        assertEquals(150.0, response.getBody().getNewBalance());
    }
}
