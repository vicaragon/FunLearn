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
            student.setFirstName(studentFirstName);
            student.setLastName(studentLastName);
 	    student.setAgeGroup(studentAgeGroup);
            manager.merge(student);
        //    manager.flush();
    	 }
    	 return student;
    }
    public Student deleteStudent(Integer studentID) {
         Student student = manager.find(Student.class, studentID);
    	 if (student != null) {
            manager.remove(student);
    	 }
         return student;
    }
    
        public Student updateScores(Integer studentID, String studentFirstName, Integer studentScore) {
         Student student = manager.find(Student.class, studentID);
    	 if (student != null) {
            if (studentScore < student.getMinScore()) {
                student.setMinScore(studentScore);
            }
            if (studentScore > student.getMaxScore()) {
                student.setMaxScore(studentScore);
            }
            int avg = (student.getAvgScore() + studentScore)/2;
            student.setAvgScore(avg);
                
            manager.merge(student);
    	 }
         return student;
    }
}
