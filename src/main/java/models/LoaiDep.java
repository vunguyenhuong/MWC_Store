
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
 * @author homna
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "LoaiDep")
public class LoaiDep implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "NgayThem")
    @Temporal(TemporalType.DATE)
    private Date ngayThem;

    @Column(name = "NgaySuaCuoi")
    @Temporal(TemporalType.DATE)
    private Date ngaySuaCuoi;

    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "loaiDep",fetch = FetchType.LAZY)
    List<ChiTietDep> listCTDep;
    
    @Override
    public String toString() {
        return ten;
    }

}
