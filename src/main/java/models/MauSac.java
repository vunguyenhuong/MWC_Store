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
 * @author Vu Nguyen Huong
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "MauSac")
public class MauSac implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
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
    
    @OneToMany(mappedBy = "mauSac",fetch = FetchType.LAZY)
    List<ChiTietDep> listCTDep;
    
    @Override
    public String toString() {
        return ten; 
    }

}
