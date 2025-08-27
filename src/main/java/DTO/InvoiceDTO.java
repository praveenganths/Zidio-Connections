package DTO;

import org.bouncycastle.asn1.dvcs.ServiceType;

import java.time.LocalDateTime;
import Enum.*;

public class InvoiceDTO {

    public Long id;
    public String userEmail;
    public ServiceType serviceType;
    public Double amount;
    public LocalDateTime purchaseDate;
    public PaymentType paymentMethod;
    public Status status;
    public String invoiceNumber;
    public String invoiceDownloadURL;
    public String subscriptionPlan;

    public InvoiceDTO(Long id, String userEmail, String invoiceNumber, String invoiceDownloadURL, String subscriptionPlan,
                      ServiceType serviceType, Double amount, LocalDateTime purchaseDate, PaymentType paymentMethod, Status status){
        this.id = id;
        this.amount = amount;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDownloadURL = invoiceDownloadURL;
        this.paymentMethod = paymentMethod;
        this.purchaseDate = purchaseDate;
        this.serviceType = serviceType;
        this.status = status;
        this.subscriptionPlan = subscriptionPlan;
        this.userEmail = userEmail;
    }
}
