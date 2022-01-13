/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Conference;
import entities.Talk;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madr1
 */
public class ConferenceDTO {
    private long id;
    private String conferenceName;
    private String location;
    private int capacity;
    private String date;
    private String time;
    private List<Talk> listOfTalks = new ArrayList<>();

    public ConferenceDTO() {
    }

    public ConferenceDTO(String conferenceName, String location, int capacity, String date, String time) {
        this.conferenceName = conferenceName;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
    }

    public ConferenceDTO(Conference conference) {
        this.id = conference.getId();
        this.conferenceName = conference.getConferenceName();
        this.location = conference.getLocation();
        this.capacity = conference.getCapacity();
        this.date = conference.getDate();
        this.time = conference.getTime();
    }

   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Talk> getListOfTalks() {
        return listOfTalks;
    }

    public void setListOfTalks(List<Talk> listOfTalks) {
        this.listOfTalks = listOfTalks;
    }

    @Override
    public String toString() {
        return "ConferenceDTO{" + "id=" + id + ", conferenceName=" + conferenceName + ", location=" + location + ", capacity=" + capacity + ", date=" + date + ", time=" + time + ", listOfTalks=" + listOfTalks + '}';
    }
    
    
}
