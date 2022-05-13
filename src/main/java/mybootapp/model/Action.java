package mybootapp.model;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAction;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 30, message = "max 30 caractères")
    @Basic
    @Column(name = "numeroAction")
    private int numeroAction;

    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @CreatedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "dateMaj")
    private Date dateMaj;

    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "dateCrea")
    private Date dateCrea;

    //liste deroulante
    @NotNull(message = "une réponse doit être choisie")
    @Basic
    @Column(name = "niveauObligatoire")
    private boolean niveauObligatoire;

    //liste deroulante
    @NotNull(message = "une réponse doit être choisie")
    @Basic
    @Column(name = "modaliteEnseignement")
    private int modaliteEnseignement;

    //liste deroulante
    @NotNull(message = "au moins un type doit être choisit")
    @ElementCollection()
    @Column(name = "rythmeFormation")
    private Collection<Integer> rythmeFormation;

    @Size(max = 3000, message = "max 3000 caractères")
    @Basic
    @Column(name = "conditionsSpecifiques")
    private String conditionsSpecifiques;


    @Size(max = 3000, message = "max 3000 caractères")
    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "modaliteEntreeSortie", length = 3000)
    private int modaliteEntreeSortie;

    @NotNull(message = "le champ ne doit pas être vide")
    @OneToOne
    @JoinColumn(name="idCoordonnee")
    private Coordonnee coordonnee;

    //dans le formulaire, proposer de choisir entre http:// et https://
    @Size(max = 400, message = "max 400 caractères")
    @Basic
    @Column(name = "url")
    private String url;

    @Size(max = 250, message = "max 250 caractères")
    @Basic
    @Column(name = "restauration")
    private String restauration;

    @Size(max = 250, message = "max 250 caractères")
    @Basic
    @Column(name = "hebergement")
    private String hebergement;

    @Size(max = 250, message = "max 250 caractères")
    @Basic
    @Column(name = "transport")
    private String transport;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 250, message = "max 250 caractères")
    @Basic
    @Column(name = "accesHandicapes")
    private String accesHandicapes;

    //liste deroulante
    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "langueFormation")
    private String langueFormation;

    @Size(max = 3000, message = "max 3000 caractères")
    @Basic
    @Column(name = "modaliteRecrutement")
    private String modaliteRecrutement;

    @Size(max = 200, message = "max 200 caractères")
    @Basic
    @Column(name = "modalitePedagogique")
    private String modalitePedagogique;

    //liste deroulante
    @Basic
    @Column(name = "perimetreRecrutement")
    private int perimetreRecrutement;

    @Size(max = 50, message = "max 50 caractères")
    @Basic
    @Column(name = "infoPerimetreRecrutement")
    private String infoPerimetreRecrutement;

    @Size(max = 5, message = "nombre maximale : 99 999")
    @Basic
    @Column(name = "nombreHeureCentre")
    private int nombreHeureCentre;

    @Size(max = 5, message = "nombre maximale : 99 999")
    @Basic
    @Column(name = "nombreHeureEntreprise")
    private int nombreHeureEntreprise;

    @Size(max = 3000, message = "max 3000 caractères")
    @Basic
    @Column(name = "modalitesHandicap")
    private String modalitesHandicap;

    //liste deroulante
    @Basic
    @Column(name = "modaliteAdmission")
    private int modaliteAdmission;

    @Size(max = 250, message = "max 250 caractères")
    @Basic
    @Column(name = "infosAdmission")
    private String infosAdmission;

    //reflechir pour limite
    @Size(max = 13, message = "valeur maximale : 9 999 999 999,99")
    @Basic
    @Column(name = "fraisANPEC")
    private int fraisANPEC;

    //liste deroulante
    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "fraisInclusANPEC")
    private boolean fraisInclusANPEC;

    @Size(max = 3000, message = "max 3000 caractères")
    @Basic
    @Column(name = "detailsFraisANPEC")
    private String detailsFraisANPEC;

    //liste deroulante
    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "modeleEconomique")
    private int modeleEconomique;

    @Size(max = 255, message = "max 255 caractères")
    @Basic
    @Column(name = "autresServices")
    private String autresServices;

    //liste deroulante
    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "tauxTVA")
    private int tauxTVA;

    //reflechir pour limite
    @Size(max = 13, message = "valeur maximale : 9 999 999 999,99")
    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "fraisHT")
    private int fraisHT;

    //reflechir pour limite
    @Size(max = 13, message = "valeur maximale : 9 999 999 999,99")
    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "fraisTTC")
    private int fraisTTC;

    //liste deroulante
    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "preRequis")
    private boolean preRequis;

    @ManyToOne
    @JoinColumn( name="idSession" )
    private Session session;
}
