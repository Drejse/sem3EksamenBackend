/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Speaker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madr1
 */
public class SpeakersDTO {
     List<SpeakerDTO> all = new ArrayList<>(); 
    
    public SpeakersDTO(List<Speaker> raEntities) {
        raEntities.forEach((ra) -> {
            all.add(new SpeakerDTO(ra));
            });
    }
    
    public List<SpeakerDTO> getAll() {
        return all;
    }
}
