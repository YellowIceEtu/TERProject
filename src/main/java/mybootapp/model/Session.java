package mybootapp.model;

import lombok.*;
import mybootapp.model.base.BaseData;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Session extends BaseData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn( name="adresse" )
    private Adresse adresse;


}
