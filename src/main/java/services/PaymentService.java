package services;


import DTO.PaymentDTO;
import entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PaymentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentDTO makePayment(PaymentDTO dto) {
        Payment pay = new Payment();
        pay.setId(dto.id);
        pay.setUserId(dto.userId);
        pay.setPlanId(dto.planId);
        pay.setAmount(dto.amount);
        pay.setCurrency(dto.currency);;
        pay.setPaymentType(dto.paymentType);
        pay.setPaymentStatus(dto.paymentStatus);
        pay.setPaymentDate(dto.paymentDate);
        pay.setTransactionId(dto.transactionId);


        Payment saved= paymentRepository.save(pay);
        dto.id=saved.getId();
        dto.paymentDate=saved.getPaymentDate();
        dto.paymentStatus=saved.getPaymentStatus();
        return dto;
    }


    public List<PaymentDTO> getAllPayments(){
        return paymentRepository.findAll().stream().map(p ->{
                    PaymentDTO dto= new PaymentDTO();
                    dto.id=p.getId();
                    dto.planId=p.getPlanId();
                    dto.userId=p.getUserId();
                    dto.amount=p.getAmount();
                    dto.currency=p.getCurrency();
                    dto.paymentType=p.getPaymentType();
                    dto.paymentStatus=p.getPaymentStatus();
                    dto.paymentDate=p.getPaymentDate();
                    return dto;})
                .collect(Collectors.toList());




    }



}
