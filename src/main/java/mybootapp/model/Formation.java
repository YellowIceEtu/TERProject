package mybootapp.model;

import lombok.*;
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
public class Formation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFormation;

    //autoremplit
    @Size(max = 30)
    @Basic()
    @Column(name = "numero")
    private int numero;

    //liste deroulante
    @NotNull(message = "une réponse doit être choisie")
    @Basic()
    @Column(name = "codeFormation")
    private int codeFormation;

    //réfléchir comment imposer une réponse
    @NotNull
    @Basic()
    @Column(name = "etatEdition")
    private String etatEdition;

    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @CreatedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "dateMaj")
    private Date dateMaj;

    @NotNull(message = "le champ ne doit pas être vide")
    @Basic
    @CreatedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "dateCrea")
    private Date dateCrea;


    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 255, message = "max 255 caractères")
    @Basic
    @Column(name = "intitule")
    private String intitule;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 3000, message = "max 3000 caractères")
    @Basic()
    @Column(name = "objectif")
    private String objectif;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 3000, message = "max 3000 caractères")
    @Basic()
    @Column(name = "resultatsAttendus")
    private String resultatsAttendus;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 3000, message = "max 3000 caractères")
    @Basic()
    @Column(name = "contenu")
    private String contenu;

    //liste deroulante
    @NotNull(message = "une réponse doit être choisie")
    @Basic()
    @Column(name = "typeParcours")
    private int typeParcours;

    //liste deroulante
    @NotNull(message = "une réponse doit être choisie")
    @Basic()
    @Column(name = "objectifGeneral")
    private int objectifGeneral;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 6, message = "max 6 caractères")
    @Basic()
    @Column(name = "CERTIFINFO")
    private int CERTIFINFO;

    @OneToOne
    @JoinColumn( name="idAction" )
    private Action action;
}
