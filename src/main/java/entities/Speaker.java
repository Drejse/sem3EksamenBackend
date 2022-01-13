/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.persistence.JoinTable;
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
@Table(name = "speaker")
public class Speaker implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 45)
  @Basic(optional = false)
  @NotNull
  @Column(name = "name", length = 25)
  private String name;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "profession")
  private String profession;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "gender")
  private String gender;
  @ManyToMany (cascade = CascadeType.PERSIST)
    private List<Talk> talksList;

    public Speaker() {
    }

/*
  public List<String> getTalksAsStrings() {
    if (talksList.isEmpty()) {
      return null;
    }
    List<String> getTalksAsStrings = new ArrayList<>();
    talksList.forEach((role) -> {
        getTalksAsStrings.add(role.getRoleName());
      });
    return rolesAsStrings;
*/

    public Speaker(String name, String profession, String gender) {
        this.name = name;
        this.profession = profession;
        this.gender = gender;
        this.talksList = new ArrayList<>();
    }
    

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }


    
    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public String getGender() {
        return gender;
    }

    public List<Talk> getTalksList() {
        return talksList;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public void setName(String name) {
        this.name = name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTalksList(List<Talk> talksList) {
        this.talksList = talksList;
    }
    
   public void addTalks(Talk talk) {
        if (talk != null){
            this.talksList.add(talk);
            //Makes the relationship bi-directional
            talk.getSpeakerList().add(this);
        }
    }
  }
    

