package controller;


import DTO.JobPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.JobPostService;

import java.util.List;

@RestController
@RequestMapping("/api/jobPosts")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;


    @PostMapping
    public ResponseEntity<JobPostDTO> createJob(@RequestBody JobPostDTO dto){
        return ResponseEntity.ok(jobPostService.postJob(dto));
    }
    @GetMapping("/recruiter")
    public ResponseEntity<List<JobPostDTO>>getByPostedEmail(@RequestParam String email){
        return ResponseEntity.ok(jobPostService.getByPostedByEmail(email));
    }
    @GetMapping("/jobTitle")
    public ResponseEntity<List<JobPostDTO>>geyByJobTitle(@RequestParam String jobTitle){
        return ResponseEntity.ok(jobPostService.getByJobTitle(jobTitle));
    }
    @GetMapping("/jobType")
    public ResponseEntity<List<JobPostDTO>>geByJobType(@RequestParam String jobType){
        return ResponseEntity.ok(jobPostService.getByJobType(jobType));

    }
    @GetMapping("/companyName")
    public ResponseEntity<List<JobPostDTO>>getByCompanyName(@RequestParam String companyName){
        return ResponseEntity.ok(jobPostService.getByCompanyName(companyName));
    }

}
