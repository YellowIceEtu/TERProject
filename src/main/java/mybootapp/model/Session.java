package mybootapp.model;

import lombok.*;
import mybootapp.model.base.BaseData;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;

    @NotBlank(message = "le champ ne doit pas être vide")
    @Pattern(regexp="[0-9]{4}[/]{1}[0-1]{1}[0-9]{1}[/]{1}[0-3]{1}[0-9]{1}", message = "format AAAA/MM/DD")
    @Basic()
    @Column(name = "debut")
    private String debut;

    @NotBlank(message = "le champ ne doit pas être vide")
    @Pattern(regexp="[0-9]{4}[0-1][0-1]{1}[0-9]{1}[0-3]{2}[0-9]{2}", message = "format AAAA/MM/DD")
    @Basic()
    @Column(name = "fin")
    private String fin;

    //checkbox non/oui -> 0/1
    @NotBlank(message = "une réponse doit être choisie")
    @Basic()
    @Column(name = "sessionOuverte")
    private int sessionOuverte;

    //liste deroulante
    @NotBlank(message = "une réponse doit être choisie")
    @Basic()
    @Column(name = "etatRecrutement")
    private int etatRecrutement;

    @NotBlank(message = "le champ ne doit pas être vide")
    @Size(max = 3000, message = "max 3000 caractères")
    @Basic()
    @Column(name = "extraInfoGarantie")
    private String extraInfoGarantie;

    @Column(updatable = false)
    @CreationTimestamp
    private Date dateCrea;
    @UpdateTimestamp
    private Date dateMaj;




}
