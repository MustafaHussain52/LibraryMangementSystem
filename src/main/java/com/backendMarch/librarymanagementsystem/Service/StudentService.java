package com.backendMarch.librarymanagementsystem.Service;

import com.backendMarch.librarymanagementsystem.DTO.StudentRequestDto;
import com.backendMarch.librarymanagementsystem.DTO.StudentResponseDto;
import com.backendMarch.librarymanagementsystem.DTO.StudentUpdateEmailRequestDto;
import com.backendMarch.librarymanagementsystem.Entity.LibraryCard;
import com.backendMarch.librarymanagementsystem.Entity.Student;
import com.backendMarch.librarymanagementsystem.Enum.CardStatus;
import com.backendMarch.librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(StudentRequestDto studentRequestDto) {

        //setting value of card
//        LibraryCard card = new LibraryCard();
//        card.setStatus(CardStatus.ACTIVATED);
//        card.setValidTill("03/2025");
//        card.setStudent(student);

        //set card attribute in student
//        student.setCard(card);
//
//        studentRepository.save(student);

        Student student = new Student();

        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());

        LibraryCard card = new LibraryCard();
        card.setStatus(CardStatus.ACTIVATED);
        card.setStudent(student);
        //setting card
        student.setCard(card);

        studentRepository.save(student);
    }

    public String findByEmail(String email){

        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }

    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){

        Student student = studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());

        Student updateStudent = studentRepository.save(student);

        //convert update student to response dto

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updateStudent.getId());
        studentResponseDto.setEmail(updateStudent.getEmail());
        studentResponseDto.setName(updateStudent.getName());

        return studentResponseDto;
    }

}
