package mybootapp.model;

import lombok.*;
import mybootapp.model.base.BaseData;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="adresse")
public class Adresse extends BaseData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic()
    @Column(name="adresse")
    String adresse;
}
