package service;

import java.sql.SQLException;
import java.util.List;
import entity.invoice;

public class BillingService {
    public CustomerService CustomerService=new CustomerService();
    public invoiceService invoiceService=new invoiceService();
    public void createInvoice(int customerId,int vehicleId, List<Integer> serviceIds) throws SQLException {
        for(int serviceId:serviceIds)
        {
            invoiceService.addInvoice(new invoice(0,customerId,vehicleId,serviceId));
        }
        System.out.println("invoice generated successfully");
    }
    public void showAllInvoices() throws SQLException {
        List<invoice> invoices=invoiceService.getAllInvoices();
        for(invoice invoice:invoices)
        {
            System.out.println(invoice);
        }
    }
}
