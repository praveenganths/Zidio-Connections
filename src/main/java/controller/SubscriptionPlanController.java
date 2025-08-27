package controller;


import DTO.SubscriptionPlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.SubscriptionPlanService;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;


    @GetMapping
    public ResponseEntity<List<SubscriptionPlanDTO>>getAll(){
        return ResponseEntity.ok(subscriptionPlanService.getAllSubscriptionPlan());
    }

    @PostMapping
    public ResponseEntity<SubscriptionPlanDTO> create(@RequestParam SubscriptionPlanDTO dto) {
        return ResponseEntity.ok(subscriptionPlanService.createSubscription(dto));
    }


}
