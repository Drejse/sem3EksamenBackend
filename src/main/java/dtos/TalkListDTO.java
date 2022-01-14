/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Speaker;
import entities.Talk;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madr1
 */
public class TalkListDTO {
    
      List<TalkDTO> all = new ArrayList<>(); 
    
    public TalkListDTO(List<Talk> raEntities) {
        raEntities.forEach((ra) -> {
            all.add(new TalkDTO(ra));
            });
    }
    
    public List<TalkDTO> getAll() {
        return all;
    }
    
}
