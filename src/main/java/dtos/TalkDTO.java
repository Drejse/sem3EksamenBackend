/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Conference;
import entities.Speaker;
import entities.Talk;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madr1
 */
public class TalkDTO {
 private long id;
 private String topic;
 private String duration;
 private String propList;
 private Conference conference;
 private List<Speaker> speakerList = new ArrayList<>();

    public TalkDTO() {
    }

    public TalkDTO(String topic, String duration, String propList, Conference conference) {
        this.topic = topic;
        this.duration = duration;
        this.propList = propList;
        this.conference = conference;
    }

    public TalkDTO(Talk talk) {
        this.id = talk.getId();
        this.topic = talk.getTopic();
        this.duration = talk.getDuration();
        this.propList = talk.getPropList();
        this.conference = talk.getConference();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPropList() {
        return propList;
    }

    public void setPropList(String propList) {
        this.propList = propList;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public List<Speaker> getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerList(List<Speaker> speakerList) {
        this.speakerList = speakerList;
    }

    @Override
    public String toString() {
        return "TalkDTO{" + "id=" + id + ", topic=" + topic + ", duration=" + duration + ", propList=" + propList + ", conference=" + conference + ", speakerList=" + speakerList + '}';
    }
 
    
 
}
