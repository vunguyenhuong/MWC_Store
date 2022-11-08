package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author cvdoa
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Size")
public class Size implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "KichCo")
    private Float kichCo;

    @Column
    @Temporal(TemporalType.DATE)
    private Date ngayThem;

    @Column
    @Temporal(TemporalType.DATE)
    private Date ngaySuaCuoi;

    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
    List<ChiTietDep> listCTDep;

    @Override
    public String toString() {
        return kichCo + "";
    }

    
}
