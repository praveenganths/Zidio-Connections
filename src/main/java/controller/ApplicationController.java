package controller;

import DTO.ApplicationDTO;
import Enum.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ApplicationService;

import java.util.List;

@RestController
@RequestMapping(name = "/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicaionService;


    @PostMapping("/apply")
    public ResponseEntity <ApplicationDTO>apply(@RequestBody ApplicationDTO dto){
        return ResponseEntity.ok(applicaionService.apply(dto));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ApplicationDTO>>getApplicationByStudentId(@PathVariable Long studentId){
        return ResponseEntity.ok(applicaionService.getApplicationByStudentId(studentId));
    }
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationDTO>>getApplicationByJoId(@PathVariable Long jobId){
        return ResponseEntity.ok(applicaionService.getApplicationByJobId(jobId));
    }
    @PostMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id,@RequestParam Status status) {
        applicaionService.updateStatus(id, status);
    }

}
