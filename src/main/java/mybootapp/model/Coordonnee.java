package mybootapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="coordonnee")
public class Coordonnee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCoordonnee;

    //autoremplit
    @Size(max = 30)
    @Basic()
    @Column(name = "numero")
    private int numero;


    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 50, message = "max 50 caractères")
    @Basic()
    @Column(name = "nom")
    private String nom;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 50, message = "max 50 caractères")
    @Basic()
    @Column(name = "prenom")
    private String prenom;

    //format complexe
    @Pattern(regexp="^[+0-9]{1}[0-9 ]")
    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 25, message = "max 25 caractères")
    @Basic()
    @Column(name = "telFixe")
    private String telFixe;

    //format complexe
    @Pattern(regexp="^[+0-9]{1}[0-9 ]")
    @Size(max = 25, message = "max 25 caractères")
    @Basic()
    @Column(name = "telPortable")
    private String telPortable;

    @Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 25, message = "max 25 caractères")
    @Basic()
    @Column(name = "courriel")
    private String courriel;

    @Size(max = 75, message = "max 75 caractères")
    @Basic()
    @Column(name = "extraInfoGarantie")
    private String extraInfoGarantie;

}
