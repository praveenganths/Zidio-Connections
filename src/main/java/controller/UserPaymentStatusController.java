package controller;


import DTO.UserPaymentStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserPaymentStatusService;

import java.util.Optional;

@RestController
@RequestMapping("/api/user_subscriptions_status")
public class UserPaymentStatusController {


    @Autowired
    private UserPaymentStatusService userPaymentStatusService;


    @PostMapping
    public ResponseEntity<UserPaymentStatusDTO> assign(@RequestBody UserPaymentStatusDTO dto ){
        return ResponseEntity.ok(userPaymentStatusService.assignSubscriptionPlan(dto));
    }

    @GetMapping("{userId}")
    public ResponseEntity<Optional<UserPaymentStatusDTO>> getStatus(@PathVariable Long userId){
        return ResponseEntity.ok(userPaymentStatusService.getStatusByUserId(userId));
    }



}
