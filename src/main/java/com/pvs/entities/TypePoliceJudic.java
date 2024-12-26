package com.pvs.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class TypePoliceJudic implements Serializable {
    public TypePoliceJudic(String nom, Collection<Pv> pvs, Collection<PvsReponses> pvsReponses) {
        this.nom = nom;
        this.pvs = pvs;
        this.pvsReponses = pvsReponses;
    }

    @Id
    @GeneratedValue
    private long id;
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "typePoliceJudic")
    private Collection<Pv> pvs;
    @JsonIgnore
    @OneToMany(mappedBy = "typePoliceJudic")
    private Collection<PvsReponses> pvsReponses;

}
