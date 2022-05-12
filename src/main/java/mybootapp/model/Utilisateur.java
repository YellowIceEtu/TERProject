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
@Table(name="utilisateur")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUtilisateur;

    @Basic
    @Column(name = "nom")
    private String nom;

    @Basic
    @Column(name = "prenom")
    private String prenom;

    @Basic
    @Column(name = "estAdmin")
    private boolean estAdmin;
}
