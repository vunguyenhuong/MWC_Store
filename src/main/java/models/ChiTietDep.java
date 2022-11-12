package models;

import java.io.Serializable;
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
import lombok.Data;

/**
 *
 * @author VU NGUYEN HUONG
 */

@Data

@Entity
@Table(name = "ChiTietDep")
public class ChiTietDep implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "idDep")
    private Dep dep;
    
    @ManyToOne
    @JoinColumn(name = "idLoaiDep")
    private LoaiDep loaiDep;
    
    @ManyToOne
    @JoinColumn(name = "idMauSac")
    private MauSac mauSac;
    
    @ManyToOne
    @JoinColumn(name = "idChatLieu")
    private ChatLieu chatLieu;
    
    @ManyToOne
    @JoinColumn(name = "idNsx")
    private NhaSX nhaSX;
    
    @ManyToOne
    @JoinColumn(name = "idSize")
    private Size size;
    
    @Column
    private String moTa;
    
    @Column
    private int soLuong;
    
    @Column
    private int giaNhap;
    
    @Column
    private int giaBan;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date ngayThem;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date ngaySuaCuoi;
    
    @Column
    private int trangThai;
}