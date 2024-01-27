package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class Bank {
    private final ClientService clientService = new ClientService();

    @PostMapping("/deposit")
    public ResponseTransaction deposit(@RequestParam int customerId, @RequestParam double amount) {
        return clientService.deposit(customerId, amount);
    }

    @GetMapping("/customer")
    public Client getCustomer(@RequestParam int customerId) {
        return clientService.getCustomer(customerId);
    }

    @PostMapping("/register")
    public void registerCustomer(@RequestParam int id, @RequestParam double balance) {
        clientService.registerCustomer(id, balance);
    }

    @PostMapping("/transfer")
    public ResponseTransaction transfer(@RequestParam int customerId, @RequestParam double amount) {
        return clientService.transfer(customerId, amount);
    }
}
