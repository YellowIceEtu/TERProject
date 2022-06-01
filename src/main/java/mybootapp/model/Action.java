package mybootapp.model;

import lombok.*;
import mybootapp.model.base.BaseData;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class Action implements Serializable {

    @Size(max = 30, message = "max 30 caractères")
    @Basic
    @Column(name = "numeroAction")
    private int numeroAction;

    //checkbox non/oui -> 0/1
    @NotBlank(message = "une réponse doit être choisie")
    @Basic
    @Column(name = "niveauObligatoire")
    private String niveauObligatoire;

    //liste deroulante
    @NotBlank(message = "une réponse doit être choisie")
    @Basic
    @Column(name = "modaliteEnseignement")
    private String modaliteEnseignement;

    //liste deroulante
    @NotBlank(message = "au moins un type doit être choisit")
    @ElementCollection()
    @Column(name = "rythmeFormation")
    private Collection<String> rythmeFormation;

    @Size(max = 3000, message = "max 3000 caractères")
    @Basic
    @Column(name = "conditionsSpecifiques")
    private String conditionsSpecifiques;

    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "modaliteEntreeSortie")
    private String modaliteEntreeSortie;

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

    @NotBlank(message = "le champ ne doit pas être vide")
    @Size(max = 250, message = "max 250 caractères")
    @Basic
    @Column(name = "accesHandicapes")
    private String accesHandicapes;

    //liste deroulante
    @NotBlank(message = "le champ ne doit pas être vide")
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
    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "modaliteAdmission")
    private String modaliteAdmission;

    @Size(max = 250, message = "max 250 caractères")
    @Basic
    @Column(name = "infosAdmission")
    private String infosAdmission;

    //reflechir pour limite
    @Size(max = 13, message = "valeur maximale : 9 999 999 999,99")
    @Basic
    @Column(name = "fraisANPEC")
    private int fraisANPEC;

    //checkbox non/oui -> 0/1
    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "fraisInclusANPEC")
    private String fraisInclusANPEC;

    @Size(max = 3000, message = "max 3000 caractères")
    @Basic
    @Column(name = "detailsFraisANPEC")
    private String detailsFraisANPEC;

    //liste deroulante
    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "modeleEconomique")
    private int modeleEconomique;

    @Size(max = 255, message = "max 255 caractères")
    @Basic
    @Column(name = "autresServices")
    private String autresServices;

    //liste deroulante
    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "tauxTVA")
    private String tauxTVA;

    //reflechir pour limite
    @Size(max = 13, message = "valeur maximale : 9 999 999 999,99")
    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "fraisHT")
    private Integer fraisHT;

    //reflechir pour limite
    @Size(max = 13, message = "valeur maximale : 9 999 999 999,99")
    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic
    @Range(min = 0, message= "le champ ne doit pas être vide")
    @Column(name = "fraisTTC")
    private Integer fraisTTC;

    //checkbox non/oui -> 0/1
    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic
    @Column(name = "preRequis")
    private String preRequis;

    @ElementCollection
    @JoinColumn( name="sessions" )
    private Collection<Session> sessions;


    public Action() {
        this.sessions = new ArrayList<>();
        this.setRythmeFormation(new ArrayList<>());


    }

    public void init(int i){
        this.setNumeroAction(i);
        this.setNiveauObligatoire("0");
        this.setModaliteEnseignement(Integer.toString(i));
        this.rythmeFormation.add("0");
        this.rythmeFormation.add("1");
        this.setConditionsSpecifiques("conditions specifiques".concat(Integer.toString(i)));
        this.setModaliteEntreeSortie("0");
        this.setUrl("url".concat(Integer.toString(i)));
        this.setRestauration("restauration".concat(Integer.toString(i)));
        this.setHebergement("hebergement".concat(Integer.toString(i)));
        this.setTransport("transport".concat(Integer.toString(i)));
        this.setAccesHandicapes("acces handicapés".concat(Integer.toString(i)));
        this.setLangueFormation("langue".concat(Integer.toString(i)));
        this.setModaliteRecrutement("modalités recrutement".concat(Integer.toString(i)));
        this.setModalitePedagogique("modalités pédagogiques".concat(Integer.toString(i)));
        this.setPerimetreRecrutement(i);
        this.setInfoPerimetreRecrutement("infos perimètre recrutement".concat(Integer.toString(i)));
        this.setNombreHeureCentre(i);
        this.setNombreHeureEntreprise(i);
        this.setModalitesHandicap("modalités handicap".concat(Integer.toString(i)));
        this.setModaliteAdmission("0");
        this.setInfosAdmission("infos admissions".concat(Integer.toString(i)));
        this.setFraisANPEC(i);
        this.setDetailsFraisANPEC("detailsfraisAnpec".concat(Integer.toString(i)));
        this.setFraisInclusANPEC("0");
        this.setModeleEconomique(i);
        this.setTauxTVA("0%");
        this.setFraisHT(i);
        this.setFraisTTC(i);
        this.setPreRequis("0");
    }
}
