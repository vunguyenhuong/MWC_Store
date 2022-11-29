package services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import models.HoaDon;
import repositories.HoaDonRepository;
import services.IHoaDonService;

/**
 *
 * @author tt
 */
public class HoaDonService implements IHoaDonService {

    private HoaDonRepository hoadonRepo = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        return hoadonRepo.getAll();
    }

    @Override
    public boolean save(HoaDon hd) {
        return hoadonRepo.save(hd);
    }

    @Override
    public boolean delete(HoaDon hd) {
        return hoadonRepo.delete(hd);
    }

    @Override
    public HoaDon getObj(String ma) {
        return hoadonRepo.getObj(ma);
    }

    @Override
    public HoaDon getObjById(int id) {
        return hoadonRepo.getObjById(id);
    }

    @Override
    public List<HoaDon> findByName(String ma) {
        return hoadonRepo.findByName(ma);
    }

    @Override
    public List<HoaDon> findByMaAndTen(String ten) {
        return hoadonRepo.getObjByMaAndKH(ten);
    }

    @Override
    public List<HoaDon> getKH(String type) {
        return hoadonRepo.getHDByKH(type);
    }

    @Override
    public List<HoaDon> getHDByCombo(int trangthai, String type) {
        return hoadonRepo.getHDCombo(trangthai, type);
    }

    @Override
    public List<HoaDon> getByTT(int trangThai) {
        return hoadonRepo.getByTT(trangThai);
    }

    @Override
    public BigDecimal doanhThuTheoThang(int thang, int nam) {
        return hoadonRepo.doanhThuTheoThang(thang, nam);
    }

    @Override
    public BigDecimal doanhThuTheoNgay(int ngay, int thang, int nam) {
        return hoadonRepo.doanhThuTheoNgay(ngay, thang, nam);
    }

}
