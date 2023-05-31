package com.example.Library.management.system.Service;


import com.example.Library.management.system.DTO.RequestDtos.StudentRequestDto;
import com.example.Library.management.system.DTO.RequestDtos.UpdateStudentMobRequestDto;
import com.example.Library.management.system.DTO.ResponseDtos.CardResponseDto;
import com.example.Library.management.system.DTO.ResponseDtos.StudentResponseDto;
import com.example.Library.management.system.DTO.ResponseDtos.UpdateStudentMobResponseDto;
import com.example.Library.management.system.Entity.Card;
import com.example.Library.management.system.Entity.Student;
import com.example.Library.management.system.Enums.CardStatus;
import com.example.Library.management.system.Exceptions.InvalidStudentId;
import com.example.Library.management.system.Repository.CardRepository;
import com.example.Library.management.system.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CardRepository cardRepository;

    public String addStudent(StudentRequestDto studentRequestDto){
        //setting values to student entity
        Student student=new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card=new Card();
        card.setValidTill("5-27-2023");
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        student.setCard(card);
        Student savedStudent=studentRepository.save(student);
        return "Student was saved";
    }

    public StudentResponseDto getStudentById(int id){
           Student student=studentRepository.findById(id).get();

           StudentResponseDto studentResponseDto=new StudentResponseDto();
          studentResponseDto.setId(student.getId());
           studentResponseDto.setName(student.getName());
           studentResponseDto.setMessage("you are the lucky one");

        CardResponseDto cardResponseDto=new CardResponseDto();
        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setUpdateOn(student.getCard().getUpdateOn());
        cardResponseDto.setValidTill(student.getCard().getValidTill());

        studentResponseDto.setCardResponseDto(cardResponseDto);

        return studentResponseDto;
    }

    public UpdateStudentMobResponseDto updateStudentMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws InvalidStudentId {
        Student student;
        try{
                     student=studentRepository.findById(updateStudentMobRequestDto.getId()).get();
        }catch (Exception e){
            throw new InvalidStudentId("Student does not exist");
        }
        student.setMobNo(updateStudentMobRequestDto.getMobNo());
        Student savedStudent=studentRepository.save(student);

        UpdateStudentMobResponseDto updateStudentMobResponseDto=new UpdateStudentMobResponseDto();
        updateStudentMobResponseDto.setId(savedStudent.getId());
        updateStudentMobResponseDto.setName(savedStudent.getName());
        updateStudentMobResponseDto.setMobNo(savedStudent.getMobNo());

        return updateStudentMobResponseDto;
    }
    public String deleteStudentById(int id) throws InvalidStudentId {
        try{
            studentRepository.deleteById(id);
        }catch (Exception e){
            throw new InvalidStudentId("invalid Student Id");
        }
        return "Student deleted successfully";
    }
    public List<StudentResponseDto> getAllStudents(){
        StudentResponseDto studentResponseDto=new StudentResponseDto();
        List<Student>students=studentRepository.findAll();
        List<StudentResponseDto>allStudents=new ArrayList<>();
        CardResponseDto cardResponseDto=new CardResponseDto();
        for(Student s:students){
            studentResponseDto.setName(s.getName());
                    studentResponseDto.setId(s.getId());
                    studentResponseDto.setMessage("something new");
//                    studentResponseDto.setCardResponseDto(s.getCardResponseDto());
            cardResponseDto.setId(s.getCard().getId());
            cardResponseDto.setValidTill(s.getCard().getValidTill());
            cardResponseDto.setCardStatus(s.getCard().getCardStatus());

            studentResponseDto.setCardResponseDto(cardResponseDto);

            allStudents.add(studentResponseDto);
        }
        return allStudents;
    }
}
