package mybootapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="composante")
public class Composante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic()
    @Column(name = "intitule")
    private String intitule;

    @OneToMany
    @Column(name = "formations")
    private List<Formation> formations;


}
