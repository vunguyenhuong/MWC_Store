package models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idCTD", nullable = false)
    private ChiTietDep ctdep;

    @ManyToOne
    @JoinColumn(name = "idHD", nullable = false)
    private HoaDon hoaDon;

    @Column
    private BigDecimal donGia;

    @Column
    private int soLuong;

    @Column
    private int trangThai;

}
