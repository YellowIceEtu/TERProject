package mybootapp.model;

import lombok.*;
import mybootapp.model.base.BaseData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@Table(name="formation")
public class Formation extends BaseData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Max(value = 99999, message = "6 caractères maximum")
    @Min(value = 0, message = "au moins un caractère")
    @Basic()
    @Column(name = "codeFormation")
    private int code;

    @Basic()
    @Column(name = "etatEdition")
    private String etatEdition;

    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic()
    @Column(name = "intitule")
    private String intitule;

    @Basic()
    @Column(name = "objectif")
    private String objectif;

    /*@Basic()
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
    private int objectifGeneral;*/

    @Max(value = 99999, message = "6 caractères maximum")
    @Min(value = 0, message = "au moins un caractère")
    @Basic()
    @Column(name = "CERTIFINFO")
    private int CERTIFINFO;

    @OneToOne
    @JoinColumn( name="idAction" )
    private Action action;

    @ManyToOne
    @JoinColumn( name="idAdresse" )
    private Adresse adresse;


    @ManyToOne
    @JoinColumn( name="idComposante" )
    private Composante composante;

    public Formation() {
        this.setIntitule("0");
        this.setCERTIFINFO(0);
        this.setCode(0);
        this.setEtatEdition("brouillon");
    }

    public void create(int i){
        this.setCode(i);
        this.setEtatEdition("brouillon");
        this.setIntitule("formation".concat(Integer.toString(i)));
        this.setObjectif("objectif".concat(Integer.toString(i)));
    }

    public void finalizeCreation(Formation f){
        this.setIntitule(f.getIntitule());
        this.setCERTIFINFO(f.getCERTIFINFO());
        this.setCode(f.getCode());
        this.setEtatEdition("brouillon");

    }

}
