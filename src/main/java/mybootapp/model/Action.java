package mybootapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="action")
public class Action implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic()
    @Column(name = "numeroAction")
    private int numeroAction;

    @Basic()
    @Temporal(TemporalType.DATE)
    @Column(name = "dateMaj")
    private Date dateMaj;

    @Basic()
    @Temporal(TemporalType.DATE)
    @Column(name = "dateCrea")
    private Date dateCrea;

    @OneToOne
    @JoinColumn(name="idCoordonnee")
    private Coordonnee coordonnee;

    @Basic()
    @Column(name = "niveauObligatoire")
    private boolean niveauObligatoire;

    @Basic
    @Column(name = "modaliteEnseignement")
    private int modaliteEnseignement;

    @ElementCollection
    @Column(name = "rythmeFormation")
    private Collection<Integer> rythmeFormation;

    @Basic
    @Column(name = "conditionsSpecifiques")
    private String conditionsSpecifiques;

    @Basic
    @Column(name = "modaliteEntreSortie")
    private int modaliteEntreSortie;

    @Basic
    @Column(name = "url")
    private String url;

    @Basic
    @Column(name = "restauration")
    private String restauration;

    @Basic
    @Column(name = "hebergement")
    private String hebergement;

    @Basic
    @Column(name = "transport")
    private String transport;

    @Basic
    @Column(name = "accesHandicapes")
    private String accesHandicapes;

    @Basic
    @Column(name = "langueFormation")
    private String langueFormation;

    @Basic
    @Column(name = "modaliteRecrutement")
    private String modaliteRecrutement;

    @Basic
    @Column(name = "modalitePedagogique")
    private String modalitePedagogique;

    @Basic
    @Column(name = "perimetreRecrutement")
    private int perimetreRecrutement;

    @Basic
    @Column(name = "infoPerimetreRecrutement")
    private String infoPerimetreRecrutement;

    @Basic
    @Column(name = "nombreHeureCentre")
    private int nombreHeureCentre;

    @Basic
    @Column(name = "nombreHeureEntreprise")
    private int nombreHeureEntreprise;

    @Basic
    @Column(name = "modalitesHandicap")
    private String modalitesHandicap;

    @Basic
    @Column(name = "infosAdmission")
    private String infosAdmission;

    @Basic
    @Column(name = "fraisANPEC")
    private int fraisANPEC;

    @Basic
    @Column(name = "fraisInclusANPEC")
    private boolean fraisInclusANPEC;

    @Basic
    @Column(name = "detailsFraisANPEC")
    private String detailsFraisANPEC;

    @Basic
    @Column(name = "modeleEconomique")
    private int modeleEconomique;

    @Basic
    @Column(name = "autresServices")
    private String autresServices;

    @Basic
    @Column(name = "tauxTVA")
    private int tauxTVA;

    @Basic
    @Column(name = "fraisHT")
    private int fraisHT;

    @Basic
    @Column(name = "fraisTTC")
    private int fraisTTC;

    @Basic
    @Column(name = "preRequis")
    private boolean preRequis;

    @ManyToOne
    @JoinColumn( name="idSession" )
    private Session session;
}
