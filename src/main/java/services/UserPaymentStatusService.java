package services;


import DTO.UserPaymentStatusDTO;
import com.netflix.discovery.converters.Auto;
import entity.UserPaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserPaymentStatusRepository;

import java.util.Optional;

@Service
public class UserPaymentStatusService {

    @Autowired
    private UserPaymentStatusRepository userPaymentStatusRepository;

    public UserPaymentStatusDTO assignSubscriptionPlan(UserPaymentStatusDTO dto) {
        UserPaymentStatus paymentStatus  = new UserPaymentStatus();
        paymentStatus.setUserId(dto.id);
        paymentStatus.setPlanId(dto.planId);
        paymentStatus.setSubscriptionStart(dto.subscriptionStart);
        paymentStatus.setSubscriptionEnd(dto.subscriptionEnd);
        paymentStatus.setStatus(dto.status);

//		userPaymentStatusRepository.save(paymentStatus);

        UserPaymentStatus saved = userPaymentStatusRepository.save(paymentStatus);
        dto.id=saved.getId();
        dto.subscriptionStart=saved.getSubscriptionStart();
        dto.subscriptionEnd=saved.getSubscriptionEnd();
        dto.status=saved.getStatus();
        return dto;
    }


    public Optional<UserPaymentStatusDTO> getStatusByUserId(Long id){
        return userPaymentStatusRepository.findByUserId(id).map(status->{
            UserPaymentStatusDTO dto = new UserPaymentStatusDTO();
            dto.id=status.getId();
            dto.planId=status.getPlanId();
            dto.userId=status.getUserId();
            dto.subscriptionStart=status.getSubscriptionStart();
            dto.subscriptionEnd=status.getSubscriptionEnd();
            dto.status=status.getStatus();
            return dto;

        });
    }


}
