package mybootapp.model.base;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseData {

    @Column(updatable = false)
    @CreationTimestamp
    private Date dateCrea;
    @UpdateTimestamp
    private Date dateMaj;

    public String printDateCrea(){
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String stringDate= DateFor.format(this.dateCrea);
        System.out.println(stringDate);
        return stringDate;
    }

    public String printDateMaj() {
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String stringDate= DateFor.format(this.dateMaj);
        System.out.println(stringDate);
        return stringDate;
    }
}