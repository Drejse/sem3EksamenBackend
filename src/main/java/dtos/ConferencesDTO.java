/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Conference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madr1
 */
public class ConferencesDTO {
   
    List<ConferenceDTO> all = new ArrayList();

    public ConferencesDTO(List<Conference> conferenceInfoEntities) {
        conferenceInfoEntities.forEach((ci) -> {
            all.add(new ConferenceDTO(ci));
        });
    }

    public List<ConferenceDTO> getAll() {
        return all;
    }
} 

