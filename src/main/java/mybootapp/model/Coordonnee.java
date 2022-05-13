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
@Table(name="coordonnee")
public class Coordonnee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCoordonnee;

    @Basic()
    @Column(name = "nom")
    private String nom;

    @Basic()
    @Column(name = "prenom")
    private String prenom;

    @Basic()
    @Column(name = "telFixe")
    private String telFixe;

    @Basic()
    @Column(name = "telPortable")
    private String telPortable;

    @Basic()
    @Column(name = "courriel")
    private String courriel;

    @Basic()
    @Column(name = "extraInfoGarantie")
    private String extraInfoGarantie;

}
