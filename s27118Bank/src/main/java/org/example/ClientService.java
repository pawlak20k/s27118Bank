package org.example;

import java.util.HashMap;
import java.util.Map;

public class ClientService {
    private final Map<Integer, Client> customerMap = new HashMap<>();

    public void registerCustomer(int id, double initialBalance) {
        customerMap.put(id, new Client(id, initialBalance));
    }

    public ResponseTransaction deposit(int customerId, double amount) {
        Client client = customerMap.get(customerId);
        if (client == null) {
            return new ResponseTransaction(StatusTransaction.DECLINED, 0);
        }
        client.setBalance(client.getBalance() + amount);
        return new ResponseTransaction(StatusTransaction.ACCEPTED, client.getBalance());
    }

    public ResponseTransaction transfer(int customerId, double amount) {
        Client client = customerMap.get(customerId);
        if (client == null || client.getBalance() < amount) {
            return new ResponseTransaction(StatusTransaction.DECLINED, 0);
        }
        client.setBalance(client.getBalance() - amount);
        return new ResponseTransaction(StatusTransaction.ACCEPTED, client.getBalance());
    }

    public Client getCustomer(int customerId) {
        return customerMap.get(customerId);
    }
}