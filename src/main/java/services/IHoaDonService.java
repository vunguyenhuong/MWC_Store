
package services;

import java.math.BigDecimal;
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
    
    List<HoaDon> getHDByCombo(int trangthai, String type);
    
    List<HoaDon> getByTT(int trangThai);
    
    BigDecimal doanhThuTheoThang(int thang, int nam);
    
    BigDecimal doanhThuTheoNgay(int ngay, int thang, int nam);
}
