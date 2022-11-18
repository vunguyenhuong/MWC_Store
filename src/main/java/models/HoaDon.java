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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author VU NGUYEN HUONG
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    @Temporal(TemporalType.DATE)
    private Date ngayThanhToan;

    @Column(name = "NgayNhanYC")
    @Temporal(TemporalType.DATE)
    private Date ngayNhanYC;

    @Column(name = "NgayGiaoHang")
    @Temporal(TemporalType.DATE)
    private Date ngayGiaoHang;

    @Column(name = "NgayNhanHang")
    @Temporal(TemporalType.DATE)
    private Date ngayNhanHang;
    
    @ManyToOne
    @JoinColumn(name = "IdND",nullable = false)
    private NguoiDung nguoiDung;
    
    @ManyToOne
    @JoinColumn(name = "IdKH",nullable = false)
    private KhachHang khachHang;
    
    @ManyToOne
    @JoinColumn(name = "IdKM",nullable = false)
    private KhuyenMai khuyenMai;
}