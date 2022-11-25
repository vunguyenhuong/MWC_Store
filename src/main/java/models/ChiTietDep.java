package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author VU NGUYEN HUONG
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "ChiTietDep")
public class ChiTietDep implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idDep", nullable = false)
    private Dep dep;

    @ManyToOne
    @JoinColumn(name = "idLoaiDep", nullable = false)
    private LoaiDep loaiDep;

    @ManyToOne
    @JoinColumn(name = "idMauSac", nullable = false)
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "idChatLieu", nullable = false)
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "idNsx", nullable = false)
    private NhaSX nhaSX;

    @ManyToOne
    @JoinColumn(name = "idSize", nullable = false)
    private Size size;

    @Column
    private String moTa;

    @Column
    private int soLuong;
    
    @Column
    private int soLuongBanRa;

    @Column
    private BigDecimal giaNhap;

    @Column
    private BigDecimal giaBan;

    @Column
    @Temporal(TemporalType.DATE)
    private Date ngayThem;

    @Column
    @Temporal(TemporalType.DATE)
    private Date ngaySuaCuoi;

    @Column
    private int trangThai;
}
