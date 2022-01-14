/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.ConferenceDTO;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author madr1
 */

    
    @Entity
@NamedQueries({
    @NamedQuery(name = "Conference.deleteAllRows", query = "DELETE from Conference")
})
@Table(name = "conference")

public class Conference implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "conference_name")
    private String conferenceName;
   @Column(name = "location")
    private String Location;
   @Column(name = "capacity")
    private int capacity;
   @Column(name = "date")
   private String date;
     @Column(name = "time")
   private String time;
     
    @OneToMany(mappedBy = "conference",  cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Talk> listOfTalks;

    public Conference() {
    }

    public Conference(String conferenceName, String Location, int capacity, String date, String time) {
        this.conferenceName = conferenceName;
        this.Location = Location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
        
    }
    
    public Conference(ConferenceDTO cdto){
        this.conferenceName = cdto.getConferenceName();
        this.Location = cdto.getLocation();
        this.capacity = cdto.getCapacity();
        this.date = cdto.getDate();
        this.time = cdto.getTime();
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
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
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

  
    
    

  

    
  

    

  
    

    
}
