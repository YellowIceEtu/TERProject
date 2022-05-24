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
@Table(name="session")
public class Session extends BaseData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn( name="idAdresse" )
    private Adresse adresse;
}
