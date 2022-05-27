package mybootapp.model;

import lombok.*;
import mybootapp.model.base.BaseData;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="utilisateur")
public class Utilisateur extends BaseData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn( name="idComposante" )
    private Composante idComposante;


    @Basic()
    @Column(name = "nom")
    private String nom;


    @Basic()
    @Column(name = "prenom")
    private String prenom;


    @Basic()
    @Column(name = "role")
    private boolean estAdmin;



}
