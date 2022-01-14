/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.TalkDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author madr1
 */  
@Entity
@Table(name = "talks")
public class Talk implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
    private long id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "topic", length = 45)
  private String topic;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "duration")
  private String duration;
  @Column(name = "prop_list")
   private String propList;
  
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Conference conference;
   
   @ManyToMany(mappedBy = "talksList",  cascade = CascadeType.PERSIST)
   @JoinColumn(name = "speaker_name", referencedColumnName = "speaker_name")
   private List<Speaker> speakerList;
   
   

    public Talk() {
    }

    public Talk(String topic, String propList,String duration,Conference conference) {
        this.topic = topic;
        this.duration = duration;
        this.propList = propList;
        this.conference = conference;
        this.speakerList = new ArrayList<>();
    }
    
    
    public Talk(TalkDTO tdto){
        this.topic = tdto.getTopic();
        this.duration = tdto.getDuration();
        this.propList = tdto.getPropList();
        this.conference = tdto.getConference();
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSpeakerList(List<Speaker> speakerList) {
        this.speakerList = speakerList;
    }

    public List<Speaker> getSpeakerList() {
        return speakerList;
    }

 
   

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public String getPropList() {
        return propList;
    }

    public void setPropList(String propList) {
        this.propList = propList;
    }

   

    
    
   
   
   
 


    }
