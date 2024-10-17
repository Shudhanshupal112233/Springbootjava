package com.example.Student_Management_system;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController //In this class we will be writing
// API end points
@RequestMapping("/student") //this will add one more character student in the url while accessing 
public class StudentController {

    HashMap<Integer,Student> hashMap = new HashMap<>();

    @PostMapping("/registerStudent")
    public String addStudent(@RequestBody Student student){
        int key = student.getRollNo();
        hashMap.put(key,student);
        return "added successfully";
    }

    @GetMapping("/getStudentInfo")
    public Student getStudent(@RequestParam("rollNo")Integer rollNo){

        Student student = hashMap.get(rollNo);

        return student;
    }

    @PutMapping("/update_student")
    public Student updatestudent(@RequestBody Student student){
        int key =student.getRollNo();
        hashMap.put(key,student);
        return  student;

    }

    @GetMapping("getbypath/{rollNo}")
    public Student getbypath(@PathVariable("rollNo") Integer rollNo){
        Student student = hashMap.get(rollNo);
        return  student;
    }



}
