package services;

import java.util.Date;
import java.util.List;
import models.ChiTietDep;
import models.HoaDon;
import models.HoaDonChiTiet;

/**
 *
 * @author KenTizz
 */
public interface IHoaDonCTService {

    List<HoaDonChiTiet> getListHoaDonCT();

    List<HoaDon> getAllHoaDon();

    List<ChiTietDep> getAllChiTietDep();

    boolean save(HoaDonChiTiet hdct);

    boolean delete(HoaDonChiTiet hdct);

    HoaDonChiTiet getobjbyId(int id);
    
    HoaDonChiTiet getobj(int idSP, int idHD);

    List<HoaDonChiTiet> findByMa(String ma);
    
    List<HoaDonChiTiet> getDoanhThu(int trangThai,Date ngayThanhToan);
}
