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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "PhanTramGiam")
    private Float phantramgiam;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "NgayBatDau")
    @Temporal(TemporalType.DATE)
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    @Temporal(TemporalType.DATE)
    private Date ngayKetThuc;

    @OneToMany(mappedBy = "khuyenMai", fetch = FetchType.LAZY)
    List<HoaDon> listHoaDon;

    @Override
    public String toString() {
        return ten;
    }

}
