package services;


import DTO.AnalyticsResponse;
import DTO.ApplicationTrackDTO;
import DTO.DashboardDTO;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    private RestTemplate restTemplate;

    public AnalyticsResponse collectData() {
        Long students= restTemplate.getForObject("http://student-service/internal/count", Long.class);
        Long recruiters= restTemplate.getForObject("http://recruiter-service/internal/count", Long.class);
        Long jobPosts= restTemplate.getForObject("http://jobPost-service/internal/count", Long.class);
        Long applications= restTemplate.getForObject("http://applcation-service/internal/count", Long.class);
        Long auth=restTemplate.getForObject("http://auth-service/internal/count", Long.class);
        Long admins=restTemplate.getForObject("http://admin-service/internal/count", Long.class);
        String email=restTemplate.getForObject("http://email-service/internal/count", String.class);
        String fileUpload=restTemplate.getForObject("http://admin-service/internal/count", String.class);
        return new AnalyticsResponse(students,recruiters,jobPosts,applications,admins,email,fileUpload);
    }

    public DashboardDTO getSummary(){
        DashboardDTO dto = new DashboardDTO();

        dto.setTotalEmployees(1000);
        dto.setTotalRecuriters(500);
        dto.setTotalJobs(400);
        dto.setTotalApplications(5000);

        return dto;
    }

    public List<ApplicationTrackDTO>getWeeklyApplicationTracker(){

        List<ApplicationTrackDTO> tracker = new ArrayList<>();

        for(int i = 6; i>=0; i--){
            ApplicationTrackDTO dto = new ApplicationTrackDTO();

            dto.setDate(LocalDate.now().minusDays(i).toString());
            dto.setApplications(50+(long)(Math.random()*100));
            tracker.add(dto);
        }

        return tracker;
    }

}
