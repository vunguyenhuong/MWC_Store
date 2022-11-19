package models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author VU NGUYEN HUONG
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "NguoiDung")
public class NguoiDung implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "Email")
    private String email;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "GioiTinh")
    private int gioiTinh;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "TrangThai")
    private int TrangThai;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "IdCV", nullable = false)
    private ChucVu chucVu;

    @OneToMany(mappedBy = "nguoiDung",fetch = FetchType.LAZY)
    List<HoaDon> listHoaDon;
    
     @OneToMany(mappedBy = "nguoiDungTT",fetch = FetchType.LAZY)
    List<HoaDon> listHoaDon1;
}
