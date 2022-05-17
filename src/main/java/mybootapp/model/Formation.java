package mybootapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="formation")
public class Formation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFormation;

    @Basic()
    @Column(name = "codeFormation")
    private int codeFormation;

    @Basic()
    @Column(name = "etatEdition")
    private String etatEdition;
/*
    @Basic()
    @Temporal(TemporalType.DATE)
    @Column(name = "dateMaj")
    private Date dateMaj;

    @Basic()
    @Temporal(TemporalType.DATE)
    @Column(name = "dateCrea")
    private Date dateCrea;*/

    @Basic()
    @Column(name = "intitule")
    private String intitule;
/*
    @Basic()
    @Column(name = "objectif")
    private String objectif;

    @Basic()
    @Column(name = "resultatsAttendus")
    private String resultatsAttendus;

    @Basic()
    @Column(name = "contenu")
    private String contenu;

    @Basic()
    @Column(name = "typeParcours")
    private int typeParcours;

    @Basic()
    @Column(name = "objectifGeneral")
    private int objectifGeneral;

    @Basic()
    @Column(name = "CERTIFINFO")
    private int CERTIFINFO;

    @OneToOne
    @JoinColumn( name="idAction" )
    private Action action;*/
}
