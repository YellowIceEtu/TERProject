package mybootapp.model;

import lombok.*;
import mybootapp.model.base.BaseData;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class Action implements Serializable {

    @Basic
    @Column(name="nom")
    private String nom;

    @ElementCollection
    @JoinColumn( name="sessions" )
    private Collection<Session> sessions;


}
