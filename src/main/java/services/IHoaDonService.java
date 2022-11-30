
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
    
    List<HoaDon> getByTT(int trangThai);
    
    List<HoaDon> filter(String tenNguoiDung, Date from, Date to, int trangThai);
    
    BigDecimal doanhThuTheoThang(int thang, int nam);
    
    BigDecimal doanhThuTheoNgay(int ngay, int thang, int nam);
}
