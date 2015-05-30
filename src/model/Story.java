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
    private String storyVideoPath;

    public Story() {
    }

    public Story(Integer storyID) {
        this.storyID = storyID;
    }

    public Story(Integer storyID, String storyName, int ageGroup, String storyVideoPath) {
        this.storyID = storyID;
        this.storyName = storyName;
        this.ageGroup = ageGroup;
        this.storyVideoPath = storyVideoPath;
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

    public String getStoryVideoPath() {
        return storyVideoPath;
    }

    public void setStoryVideoPath(String storyVideoPath) {
        this.storyVideoPath = storyVideoPath;
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
