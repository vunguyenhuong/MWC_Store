/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.Date;
import java.util.List;
import models.HoaDon;

/**
 *
 * @author tt
 */
public interface IHoaDonService {
    List<HoaDon> getAll();
    
    boolean save(HoaDon hd);
    
    boolean delete(HoaDon hd);
    
    HoaDon getObj(String ma);
    
    HoaDon getObjById(int id);
    
    List<HoaDon> findByName(String ma);
    
    List<HoaDon> findByMaAndTen(String ten); 
    
    List<HoaDon> getKH(String type);
    
    List<HoaDon> getHDByTT(int trangthai, String type, Date from, Date to);
    
    List<HoaDon> getByTT(int trangThai);
}
