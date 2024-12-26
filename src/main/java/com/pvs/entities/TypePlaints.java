package com.pvs.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class TypePlaints implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 45)
    private String nom;

    // RelationShips:
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "typePlaints")
    private Collection<Plaints> plaints;
}
