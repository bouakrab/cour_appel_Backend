package com.pvs.entities;

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
public class DataParties implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(length = 45)
    private String soi;

    @Column(length = 45)
    private String morale;

    @Column(length = 45)
    private String genre;

    @Column(length = 45)
    private String nom;

    @Column(length = 45)
    private String prenom;

    @Column(length = 45)
    private String numCart;

    @Column(length = 45)
    private String nomDePere;

    @Column(length = 45)
    private String filsDe;

    @Column(length = 45)
    private String nomDeMere;

    @Column(length = 45)
    private String filleDe;

    @Column(length = 45)
    private String dataPartieCol;

    @Column(length = 45)
    private String profession;

    @Column(length = 45)
    private String lieuDeTravail;

    @Column(length = 45)
    private String numFinan;

    private Date dateNaiss;

    @Column(length = 45)
    private String dataPersonneCol;

    // relationships :

    @ManyToOne
    private SituationFamils situationFamils;
    @ManyToOne
    private Nationalites nationalites;
    @ManyToOne
    private PersonneMorales personneMorales;
    @ManyToOne
    private Provinces provinces;
    @ManyToOne
    private TypeCartIdents typeCartIdents;
    @ManyToOne
    private VilleDeNaiss villeDeNaisses;
    @ManyToOne
    private Pays pays;
    @ManyToMany
    private Collection<Pv> pv;
    @ManyToMany
    private Collection<Plaints> plaints;
}
