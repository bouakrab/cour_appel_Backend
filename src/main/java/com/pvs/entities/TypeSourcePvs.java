package com.pvs.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TypeSourcePvs implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nom;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "typeSourcePvs")
    private Collection<Pv> pvs;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "typeSourcePvs")
    private Collection<PvsReponses> pvsReponses;



}
