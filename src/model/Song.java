/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author me
 */
@MappedSuperclass
@Table(catalog = "FunLearnDB", schema = "")
@XmlRootElement
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer songID;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String songName;
    private Integer ageGroup;
    @Column(length = 45)
    private String language;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String songVideoPath;

    public Song() {
    }

    public Song(Integer songID) {
        this.songID = songID;
    }

    public Song(Integer songID, String songName, String songVideoPath) {
        this.songID = songID;
        this.songName = songName;
        this.songVideoPath = songVideoPath;
    }

    public Integer getSongID() {
        return songID;
    }

    public void setSongID(Integer songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Integer getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(Integer ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSongVideoPath() {
        return songVideoPath;
    }

    public void setSongVideoPath(String songVideoPath) {
        this.songVideoPath = songVideoPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (songID != null ? songID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.songID == null && other.songID != null) || (this.songID != null && !this.songID.equals(other.songID))) {
            return false;
        }
        return true;
    }
    
     public int getNumberOfColumns() {
	   return 5;
   }
       
          // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return Integer.toString(getSongID());
	   else if (i == 1)
		   return getSongName();
	   else if (i == 2) 
		   return Integer.toString(getAgeGroup());
	   else if (i == 3)
		   return getLanguage();
	   else if (i == 4)
		   return getSongVideoPath();
           
	   else
		   throw new Exception("Error: invalid column index in song table");    
   }
       
    
    @Override
    public String toString() {
        return "model.Song[ songID=" + songID + " ]";
    }
    
}
