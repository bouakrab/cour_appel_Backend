package com.pvs.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plaints implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private boolean contreInconnu;
    @Column(length = 45)
    private String referencePlaints;
    private Date datePlaints;
    private Date dateEnregPlaints;
    private Date dateFaits;
    @Column(length = 45)
    private String emplaceFaits;
    @Column(length = 45)
    private String sujetPlaints;

    // RelationShips:

    @ManyToOne
    private TypePlaints typePlaints;
    @ManyToOne
    private SourcePlaints sourcePlaints;
    @OneToMany(mappedBy = "plaints")
    private Collection<PvsReponses>pvsReponses;

    @ManyToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<DataParties> DataParties;

}
