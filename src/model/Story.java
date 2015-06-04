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
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author me
 */
@Entity(name = "story")
public class Story implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer storyID;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String storyName;
    @Basic(optional = false)
    @Column(nullable = false)
    private int ageGroup;
    @Column(length = 45)
    private String language;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String storyAudioPath;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String storyTexts;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String storyPicturePaths;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String storyPictureTime;

    public Story() {
    }

    public Story(Integer storyID) {
        this.storyID = storyID;
    }

    public Story(Integer storyID, String storyName, int ageGroup, String storyAudioPath, String storyTexts, String storyPicturePaths, String storyPictureTime) {
        this.storyID = storyID;
        this.storyName = storyName;
        this.ageGroup = ageGroup;
        this.storyAudioPath = storyAudioPath;
        this.storyTexts = storyTexts;
        this.storyPicturePaths = storyPicturePaths;
        this.storyPictureTime = storyPictureTime;
    }

    public Integer getStoryID() {
        return storyID;
    }

    public void setStoryID(Integer storyID) {
        this.storyID = storyID;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStoryAudioPath() {
        return storyAudioPath;
    }

    public void setStoryAudioPath(String storyAudioPath) {
        this.storyAudioPath = storyAudioPath;
    }

    public String getStoryTexts() {
        return storyTexts;
    }

    public void setStoryTexts(String storyTexts) {
        this.storyTexts = storyTexts;
    }

    public String getStoryPicturePaths() {
        return storyPicturePaths;
    }

    public void setStoryPicturePaths(String storyPicturePaths) {
        this.storyPicturePaths = storyPicturePaths;
    }

    public String getStoryPictureTime() {
        return storyPictureTime;
    }

    public void setStoryPictureTime(String storyPictureTime) {
        this.storyPictureTime = storyPictureTime;
    }
    
    public int getNumberOfColumns() {
        return 8;
    }
    
    // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return Integer.toString(getStoryID());
	   else if (i == 1)
		   return getStoryName();
	   else if (i == 2) 
		   return Integer.toString(getAgeGroup());
	   else if (i == 3)
		   return getLanguage();
	   else if (i == 4)
		   return getStoryAudioPath();
           else if (i == 5)
                   return getStoryTexts();
	   else if (i == 6)
		   return getStoryPicturePaths();
	   else if (i == 7)
		   return getStoryPictureTime();
	   else
		   throw new Exception("Error: invalid column index in song table");    
   }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storyID != null ? storyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Story)) {
            return false;
        }
        Story other = (Story) object;
        if ((this.storyID == null && other.storyID != null) || (this.storyID != null && !this.storyID.equals(other.storyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Story[ storyID=" + storyID + " ]";
    }
    
}
