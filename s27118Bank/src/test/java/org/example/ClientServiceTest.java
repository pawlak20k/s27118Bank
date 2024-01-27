package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTest {
    @Test
    public void testRegisterCustomer() {
        ClientService service = new ClientService();
        service.registerCustomer(1, 100.0);
        assertNotNull(service.getCustomer(1));
    }
    @Test
    public void testRegisterMultipleCustomers() {
        ClientService service = new ClientService();
        service.registerCustomer(1, 100.0);
        service.registerCustomer(2, 50.0);

        assertNotNull(service.getCustomer(1));
        assertNotNull(service.getCustomer(2));
    }
    @Test
    public void testGetNonexistentCustomer() {
        ClientService service = new ClientService();

        assertNull(service.getCustomer(1));
    }
    @Test
    public void testDepositAccepted() {
        ClientService clientService = new ClientService();
        clientService.registerCustomer(1, 0.0);

        ResponseTransaction response = clientService.deposit(1, 150.0);

        assertEquals(StatusTransaction.ACCEPTED, response.getStatus());
        assertEquals(150.0, response.getNewBalance());
    }

    @Test
    public void testDepositDeclined() {
        ClientService clientService = new ClientService();

        ResponseTransaction response = clientService.deposit(1, 50.0);

        assertEquals(StatusTransaction.DECLINED, response.getStatus());
        assertEquals(0, response.getNewBalance());
    }


    @Test
    public void testTransferDeclined() {
        ClientService clientService = new ClientService();

        ResponseTransaction response = clientService.transfer(1, 50.0);

        assertEquals(StatusTransaction.DECLINED, response.getStatus());
        assertEquals(0, response.getNewBalance());
    }
}