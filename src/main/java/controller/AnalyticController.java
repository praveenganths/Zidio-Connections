package controller;


import DTO.ApplicationTrackDTO;
import DTO.DashboardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.AnalyticsService;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class AnalyticController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/summary")
    public ResponseEntity<DashboardDTO>getSummary(){
        return ResponseEntity.ok(analyticsService.getSummary());
    }

    @GetMapping("/applications/weekly")
    public ResponseEntity<List<ApplicationTrackDTO>>getWeeklyTrackers(){
        return ResponseEntity.ok(analyticsService.getWeeklyApplicationTracker());
    }
}
