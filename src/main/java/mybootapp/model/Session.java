package mybootapp.model;

import lombok.*;

import javax.persistence.*;
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

    @Basic()
    @Column(name = "codeSession")
    private int codeSession;

    @Basic()
    @Temporal(TemporalType.DATE)
    @Column(name = "dateMaj")
    private Date dateMaj;

    @Basic()
    @Temporal(TemporalType.DATE)
    @Column(name = "dateCrea")
    private Date dateCrea;

    @Basic()
    @Temporal(TemporalType.DATE)
    @Column(name = "debut")
    private Date debut;

    @Basic()
    @Temporal(TemporalType.DATE)
    @Column(name = "fin")
    private Date fin;

    @Basic()
    @Column(name = "sessionOuverte")
    private boolean sessionOuverte;

    @Basic()
    @Column(name = "etatRecrutement")
    private int etatRecrutement;

    @Basic()
    @Column(name = "extraInfoGarantie")
    private boolean extraInfoGarantie;
}
