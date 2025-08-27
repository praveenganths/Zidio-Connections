package entity;


import org.bouncycastle.asn1.dvcs.ServiceType;

import javax.persistence.*;
import java.time.LocalDateTime;
import Enum.*;

@Entity
@Table(name = "invoices")
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String userEmail;
    private ServiceType serviceType;
    private Double amount;
    private LocalDateTime purchaseDate;
    private PaymentType paymentMethod;
    private Status status;
    private String invoiceNumber;
    private String invoiceDownloadURL;
    private String subscriptionPlan;

    public Invoice(){}

    public Long getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public PaymentType getPaymentMethod() {
        return paymentMethod;
    }

    public Status getStatus() {
        return status;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getInvoiceDownloadURL() {
        return invoiceDownloadURL;
    }

    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPaymentMethod(PaymentType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setInvoiceDownloadURL(String invoiceDownloadURL) {
        this.invoiceDownloadURL = invoiceDownloadURL;
    }

    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
}

