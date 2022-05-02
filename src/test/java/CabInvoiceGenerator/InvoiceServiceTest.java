package CabInvoiceGenerator;
import com.bridgelabz.CabInvoiceGenerator.CabInvoiceGenerator;

import com.bridgelabz.CabInvoiceGenerator.InvoiceSummary;
import com.bridgelabz.CabInvoiceGenerator.Ride;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator invoiceService = new  CabInvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.CalculateFare(distance, time);
        Assertions.assertEquals(25, totalFare,0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        CabInvoiceGenerator invoiceService = new  CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceService.CalculateFare(distance, time);
        Assertions.assertEquals(5.0, totalFare,0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalOfTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5.0, 10),
                new Ride(0.1, 1),
                new Ride(20, 60)
        };
        CabInvoiceGenerator invoiceService = new  CabInvoiceGenerator();
        double totalFare = invoiceService.calculateFareForMultipleRides(rides);
        Assertions.assertEquals(260, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        CabInvoiceGenerator invoiceService = new CabInvoiceGenerator();
        InvoiceSummary invoiceSummary = invoiceService.invoiceSummaryCalculation(rides);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        CabInvoiceGenerator invoiceService = new CabInvoiceGenerator();
        InvoiceSummary invoiceSummary = invoiceService.getInvoice(1);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30);
        Assertions.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }
}
