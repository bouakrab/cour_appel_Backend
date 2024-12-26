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
public class PvsReponses implements Serializable {
    @Id
    private long id;
    private Date numEnvoi;
    private Date datePvs;
    private Date heurRealisation;
    private boolean contreInnconue;

    @ManyToOne
    private TypeSourcePvs typeSourcePvs;

    @ManyToOne
    private TypePoliceJudic typePoliceJudic;
    @ManyToOne
    private Plaints plaints;


}
