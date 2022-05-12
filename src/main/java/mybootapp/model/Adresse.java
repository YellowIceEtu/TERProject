package mybootapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="adresse")
public class Adresse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic()
    @Column(name = "nom")
    private String nom;

    @Basic()
    @Column(name = "ligne1")
    private String ligne1;

    @Basic()
    @Column(name = "ligne2")
    private String ligne2;

    @Basic()
    @Column(name = "ligne3")
    private String ligne3;

    @Basic()
    @Column(name = "codePostal")
    private int codePostal;

    @Basic()
    @Column(name = "codePays")
    private String codePays;

    @Basic()
    @Column(name = "ligne5")
    private String ligne5;

    @Basic()
    @Column(name = "numeroVoie")
    private int numerVoie;

    @Basic()
    @Column(name = "indiceRepetition")
    private String indiceRepetition;

    @Basic()
    @Column(name = "natureDeVoie")
    private String natureDeVoie;

    @Basic()
    @Column(name = "libelleAcessibiliteBatimentaire")
    private String libelleAccessibiliteBatimentaire;

    @Basic()
    @Column(name = "conformiteReglementaire")
    private boolean conformiteReglementaire;
}
