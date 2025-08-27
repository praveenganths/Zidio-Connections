package controller;


import DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/email/{email}")
    public ResponseEntity<StudentDTO> getStudentByEmail(@PathVariable String email){
        return ResponseEntity.ok(studentService.getStudentByEmail(email));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<StudentDTO>getStudentById( @PathVariable Long id ){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @PostMapping
    public ResponseEntity<StudentDTO>createOrUpdateStudent(@RequestBody StudentDTO dto){
        return ResponseEntity.ok(studentService.createOrUpdateStudent(dto));
    }

}
