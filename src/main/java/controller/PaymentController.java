package controller;


import DTO.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/ap/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentDTO> pay(@RequestBody PaymentDTO dto ){
        return ResponseEntity.ok(paymentService.makePayment(dto));
    }

    @GetMapping
    public ResponseEntity<List<PaymentDTO>>getAll(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }
}
