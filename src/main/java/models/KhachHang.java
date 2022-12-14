package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "KhachHang")

public class KhachHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "Sdt")
    private String soDt;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "DiemTichLuy")
    private int diemTichLuy;

    @Column(name = "tongDiemTichLuy")
    private int tongDiemTichLuy;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    List<HoaDon> listHoaDon;

    @Override
    public String toString() {
        return ten;
    }
}
