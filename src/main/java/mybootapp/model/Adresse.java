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
public class Adresse implements Serializable{


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic()
    @Column(name = "ligne")
    private String ligne;




}
