/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Speaker;

/**
 *
 * @author madr1
 */
public class SpeakerDTO {
    private long id;
    private String name;
    private String profession;
    private String gender;
    
    
    public SpeakerDTO() {
    }
    
    
    public SpeakerDTO(String name, String profession, String gender) {
        this.name = name;
        this.profession = profession;
        this.gender = gender;
    }

    public SpeakerDTO(Speaker speaker) {
        this.id = speaker.getId();
        this.name = speaker.getName();
        this.profession = speaker.getProfession();
        this.gender = speaker.getGender();
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "SpeakerDTO{" + "id=" + id + ", name=" + name + ", profession=" + profession + ", gender=" + gender + '}';
    }

    
    
    
}
