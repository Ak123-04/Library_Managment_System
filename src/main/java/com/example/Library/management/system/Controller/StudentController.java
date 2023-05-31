package com.example.Library.management.system.Controller;


import com.example.Library.management.system.DTO.RequestDtos.StudentRequestDto;
import com.example.Library.management.system.DTO.RequestDtos.UpdateStudentMobRequestDto;
import com.example.Library.management.system.DTO.ResponseDtos.StudentResponseDto;
import com.example.Library.management.system.DTO.ResponseDtos.UpdateStudentMobResponseDto;
import com.example.Library.management.system.Entity.Student;
import com.example.Library.management.system.Exceptions.InvalidStudentId;
import com.example.Library.management.system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){

        return studentService.addStudent(studentRequestDto);

    }
    @GetMapping("/get_student")
    public StudentResponseDto getStudentById(@RequestParam("id") int id){
           return studentService.getStudentById(id);
    }

    @PutMapping("/update")
    public UpdateStudentMobResponseDto updateMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws InvalidStudentId {
        return studentService.updateStudentMobNo(updateStudentMobRequestDto);
    }

    @DeleteMapping("/delete")
    public String deleteStudentById(@RequestParam("id")int id) throws InvalidStudentId {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/all_students")
    public List<StudentResponseDto> getAllStudents(){
        return studentService.getAllStudents();
    }
}
