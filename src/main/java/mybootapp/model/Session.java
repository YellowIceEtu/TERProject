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
@Table(name="session")
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSession;

    //autoremplit
    @Size(max = 30)
    @Basic()
    @Column(name = "numero")
    private int numero;

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
    @Basic()
    @Temporal(TemporalType.DATE)
    @Column(name = "debut")
    private Date debut;

    @NotNull(message = "le champ ne doit pas être vide")
    @Basic()
    @Temporal(TemporalType.DATE)
    @Column(name = "fin")
    private Date fin;

    //checkbox non/oui -> 0/1
    @NotNull(message = "une réponse doit être choisie")
    @Basic()
    @Column(name = "sessionOuverte")
    private boolean sessionOuverte;

    //liste deroulante
    @NotNull(message = "une réponse doit être choisie")
    @Basic()
    @Column(name = "etatRecrutement")
    private int etatRecrutement;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 3000, message = "max 3000 caractères")
    @Basic()
    @Column(name = "extraInfoGarantie")
    private String extraInfoGarantie;

    @NotNull(message = "le champ ne doit pas être vide")
    @OneToOne
    @JoinColumn(name="idCoordonnee")
    private Coordonnee coordonnee;
}
