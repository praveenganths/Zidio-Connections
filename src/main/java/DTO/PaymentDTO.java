package DTO;

import Enum.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDTO {

    public Long id;
    public Long userId;
    public Long planId;

    public String transactionId;
    public BigDecimal amount;
    public String currency;


    public PaymentStatus paymentStatus;
    public PaymentType paymentType;
    public LocalDateTime paymentDate;

    public PaymentDTO(Long id, Long userId, Long planId, String transactionId, BigDecimal amount, String currency,
                      PaymentStatus paymentStatus, PaymentType paymentType, LocalDateTime paymentDate){
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.currency = currency;
        this.planId = planId;
        this.transactionId = transactionId;
        this.userId = userId;
    }
}
