package mybootapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "le champ ne doit pas être vide")
    @Size(max = 250, message = "max 250 caractères")
    @Basic()
    @Column(name = "nom")
    private String nom;

    @NotBlank(message = "le champ ne doit pas être vide")
    @Size(max = 250, message = "max 250 caractères")
    @Basic()
    @Column(name = "prenom")
    private String prenom;

    @NotBlank(message = "Choisir true ou false")
    @NotNull
    @Basic()
    @Column(name = "isAdmin")
    private boolean isAdmin;

    @ManyToOne
    @JoinColumn( name="idComposante" )
    private Composante idComposante;

    @NotNull
    @Basic
    @Column(name = "idCAS")
    private String idCAS;



}

