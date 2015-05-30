/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author me
 */
@Entity
@Table(catalog = "FunLearnDB", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"studentID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentID", query = "SELECT s FROM Student s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Student.findByPicPath", query = "SELECT s FROM Student s WHERE s.picPath = :picPath"),
    @NamedQuery(name = "Student.findByMaxScore", query = "SELECT s FROM Student s WHERE s.maxScore = :maxScore"),
    @NamedQuery(name = "Student.findByMinScore", query = "SELECT s FROM Student s WHERE s.minScore = :minScore"),
    @NamedQuery(name = "Student.findByAvgScore", query = "SELECT s FROM Student s WHERE s.avgScore = :avgScore"),
    @NamedQuery(name = "Student.findByAgeGroup", query = "SELECT s FROM Student s WHERE s.ageGroup = :ageGroup")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer studentID;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String firstName;
    @Column(length = 45)
    private String lastName;
    @Column(length = 45)
    private String picPath;
    private Integer maxScore;
    private Integer minScore;
    private Integer avgScore;
    private Integer ageGroup;

    public Student() {
    }

    public Student(Integer studentID) {
        this.studentID = studentID;
    }

    public Student(Integer studentID, String firstName) {
        this.studentID = studentID;
        this.firstName = firstName;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }

    public Integer getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(Integer ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Student[ studentID=" + studentID + " ]";
    }
    
}
