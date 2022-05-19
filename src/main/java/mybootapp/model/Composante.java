package mybootapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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


    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 250, message = "max 250 caractères")
    @Basic()
    @Column(name = "intitule")
    private String intitule;

    /*@OneToOne
    @JoinColumn( name="idUtilisateur" )
    private Utilisateur correspondant;*/

    @OneToMany
    @JoinColumn( name="idFormation" )
    private Collection<Formation> formations;

    public void addFormation(Formation f){
        formations.add(f);
    }
}
