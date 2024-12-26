package com.pvs.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SourcePvs implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(length=255)
    private String nom;

    public SourcePvs(String nom, Collection<Pv> pvs) {
        this.nom = nom;
        this.pvs = pvs;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "sourcePvs")
    private Collection<Pv> pvs;

}
