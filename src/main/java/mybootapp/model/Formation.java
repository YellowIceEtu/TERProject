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

    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic()
    @Column(name = "objectif")
    private String objectif;

    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic()
    @Column(name = "resultatsAttendus")
    private String resultatsAttendus;

    @NotBlank(message = "le champ ne doit pas être vide")
    @Basic()
    @Column(name = "contenu")
    private String contenu;

    @Basic()
    @Column(name = "typeParcours")
    private int typeParcours;

    @Basic()
    @Column(name = "objectifGeneral")
    private int objectifGeneral;

    @Max(value = 99999, message = "6 caractères maximum")
    @Min(value = 0, message = "au moins un caractère")
    @Basic()
    @Column(name = "CERTIFINFO")
    private int CERTIFINFO;

    @Embedded
    @JoinColumn( name="action" )
    private Action action;

    @ManyToOne
    @JoinColumn( name="adresse" )
    private Adresse adresse;


    @ManyToOne
    @JoinColumn( name="composante" )
    private Composante composante;

    public Formation() {
        this.action = new Action();
    }

    public void init(int i){
        this.setCode(i);
        this.setEtatEdition("brouillon");
        this.setIntitule("formation".concat(Integer.toString(i)));
        this.setObjectif("objectif".concat(Integer.toString(i)));
        this.setContenu("contenu".concat(Integer.toString(i)));
        this.setResultatsAttendus("resultats".concat(Integer.toString(i)));
        this.getAction().setNom("action".concat(Integer.toString(i)));
    }
}
