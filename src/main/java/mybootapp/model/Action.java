package mybootapp.model;

import lombok.*;
import mybootapp.model.base.BaseData;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="action")
public class Action extends BaseData implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany
    @JoinColumn( name="idSession" )
    private Collection<Session> sessions;


}
