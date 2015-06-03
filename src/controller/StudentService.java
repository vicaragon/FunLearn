/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Student;
import javax.persistence.*;
import java.util.*;
/**
 *
 * @author rramsis
 */
public class StudentService {
    private EntityManager manager;
    public StudentService(EntityManager manager) {
        this.manager = manager;
    }
    public Student createStudent(Integer studentID, String studentFirstName, String studentLastName, Integer studentAgeGroup, Integer studentMinScore, Integer studentMaxScore, Integer studentAvgScore) {
            Student student = new Student();
            student.setStudentID(studentID);
 	    student.setFirstName(studentFirstName);
            student.setLastName(studentLastName);
 	    student.setAgeGroup(studentAgeGroup);
 	    student.setMinScore(studentMinScore);
 	    student.setMaxScore(studentMaxScore);
 	    student.setAvgScore(studentAvgScore);
 	    manager.persist(student);
 	    return student;
    }
    public Student readStudent(Integer studentID) {
        Student student = manager.find(Student.class, studentID);
    	 return student;  
    }
    
    public List<Student> readAll() {
    	 TypedQuery<Student> query = manager.createQuery("SELECT e FROM student e", Student.class);
    	 List<Student> result =  query.getResultList();

    	 return result;   	 
     }
         
    public Student updateStudent(Integer studentID, String studentFirstName, String studentLastName, Integer studentAgeGroup) {
         Student student = manager.find(Student.class, studentID);
    	 if (student != null) {
            student.setLastName(studentFirstName);
            student.setLastName(studentLastName);
 	    student.setAgeGroup(studentAgeGroup);
 	//    student.setMinScore(studentMinScore);
 	//    student.setMaxScore(studentMaxScore);
 	//    student.setAvgScore(studentAvgScore);
    	 }
    	 return student;
    }
    public void deleteStudent(Integer studentID) {
         Student student = manager.find(Student.class, studentID);
    	 if (student != null) {
            manager.remove(student);
    	 }
    }
}
