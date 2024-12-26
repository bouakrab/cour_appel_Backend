package com.pvs.entities;


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
public class User implements Serializable {
    @Id
    private long id;
    @Column(length =45)
    private String nom;
    @Column(length =45)
    private String email;
    @Column(length =45)
    private String password;

    @ManyToOne
    private Roles roles;



}
