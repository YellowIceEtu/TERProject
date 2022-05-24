package mybootapp.model;

import lombok.*;
import mybootapp.model.base.BaseData;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="formation")
public class Formation extends BaseData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "codeFormation")
    private int code;

    @Basic()
    @Column(name = "etatEdition")
    private String etatEdition;

    @NotNull
    @Size(min = 1, max = 255, message = "le champ doit contenir entre 1 et 255 caractères")
    @Basic
    @Column(name = "intitule")
    private String intitule;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 3000, message = "max 3000 caractères")
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
    private int objectifGeneral;

    @Basic()
    @Column(name = "CERTIFINFO")
    private int CERTIFINFO;*/

    /*@OneToOne
    @JoinColumn( name="idAction" )
    private Action action;*/

    /*@ManyToOne
    @JoinColumn( name="idAdresse" )
    private Adresse adresse;*/
}
