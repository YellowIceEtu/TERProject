package mybootapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="composante")
public class Composante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idComposante;

    @Basic()
    @Column(name = "intitule")
    private String intitule;

    @OneToOne
    @JoinColumn( name="idUtilisateur" )
    private Utilisateur utilisateur;

    @OneToMany
    @JoinColumn( name="idFormation" )
    private Collection<Formation> formations;


}
