package mybootapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="utilisateur")
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUtilisateur;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 50, message = "max 50 caractères")
    @Basic
    @Column(name = "nom")
    private String nom;

    @NotNull(message = "le champ ne doit pas être vide")
    @Size(max = 50, message = "max 50 caractères")
    @Basic
    @Column(name = "prenom")
    private String prenom;

    //checkbox
    @NotNull(message = "choisissez une réponse")
    @Basic
    @Column(name = "estAdmin")
    private boolean estAdmin;
}
