package mybootapp.model;

import lombok.*;
import mybootapp.model.base.BaseData;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="adresse")
public class Adresse extends BaseData implements Serializable {

    String adresse;
}
