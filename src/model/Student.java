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

/**
 *
 * @author me
 */
@Entity(name = "student")
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
    
    public int getNumberOfColumns() {
	   return 7;
   }
    
    public String getColumnData(int i) throws Exception {
            if (i == 0) 
		   return Integer.toString(getStudentID());  
           else if (i == 1)
		   return getFirstName();
	   else if (i == 2)
		   return getLastName();
	   else if (i == 3) 
		   return Integer.toString(getAgeGroup());
	   else if (i == 4)
		   return Integer.toString(getMinScore());
	   else if (i == 5)
		   return Integer.toString(getMaxScore());
           else if (i == 6)
		   return Integer.toString(getAvgScore());
           else if (i == 7)
		   return Integer.toString(getStudentID());
	   else
		   throw new Exception("Error: invalid column index in courselist table");    
   }
    
       public String getColumnName(int i) throws Exception {
	   String colName = null;
	   if (i == 0) 
		   colName = "ID";
	   else if (i == 1)
		   colName = "first_name";
	   else if (i == 2)
		   colName = "last_name";
	   else if (i == 3)
		   colName = "age_group";
	   else if (i == 4)
		   colName = "min_score";
           else if (i == 5)
		   colName = "max_score";
           else if (i == 6)
		   colName = "avg_score";
	   else 
		   throw new Exception("Access to invalid column number in courselist table");
	   
	   return colName;
   }

       public void setColumnData(int i, Object value) throws Exception {
           if (i == 0) 
		   studentID = Integer.parseInt((String) value);
	   else if (i == 1) 
		   firstName = (String) value;
	   else if (i == 2) 
		   lastName = (String) value;
	   else if (i == 3)
		   ageGroup =  Integer.parseInt((String) value);
	   else if (i == 4)
		  minScore = Integer.parseInt((String) value);
           else if (i == 5)
		  maxScore = Integer.parseInt((String) value);  
           else if (i == 6)
		  avgScore = Integer.parseInt((String) value); 
	   else
		   throw new Exception("Error: invalid column index in courselist table");  
   }
       
    @Override
    public String toString() {
        return "Student[studentFirstName =" + firstName + ","
    	    + " studentLastName =" + lastName + ","
    	    + " studentAge =" + ageGroup + ","
    	    + " minScore =" + minScore + ","
            + " maxScore =" + maxScore + ","
            + " avgScore =" + avgScore + ","
        + "]";
    }
    
}
