/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Student;
import javax.persistence.EntityManager;
/**
 *
 * @author rramsis
 */
public class StudentService {
    private EntityManager manager;
    public StudentService(EntityManager manager) {
        this.manager = manager;
    }
    public Student creatStudent() {
        return null;
    }
    public Student readStudent() {
        return null;
    }
    public Student updateStudent() {
        return null;
    }
    public Student deleteStudent() {
        return null;
    }
}
