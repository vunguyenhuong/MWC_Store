package services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.ChiTietDep;
import models.HoaDon;
import models.HoaDonChiTiet;
import repositories.ChiTietDepRepository;
import repositories.HoaDonCTRepository;
import repositories.HoaDonRepository;
import services.IHoaDonCTService;

/**
 *
 * @author KenTizz
 */
public class HoaDonCTService implements IHoaDonCTService {

    private HoaDonCTRepository repo = new HoaDonCTRepository();
    private ChiTietDepRepository repoCTDep = new ChiTietDepRepository();
    private HoaDonRepository repoHoaDon = new HoaDonRepository();

    @Override
    public List<HoaDonChiTiet> getListHoaDonCT() {
        return repo.getAll();
    }

    @Override
    public List<HoaDon> getAllHoaDon() {
        return repoHoaDon.getAll();
    }

    @Override
    public List<ChiTietDep> getAllChiTietDep() {
        return repoCTDep.getAll();
    }

    @Override
    public boolean save(HoaDonChiTiet hdct) {
        return repo.save(hdct);
    }

    @Override
    public boolean delete(HoaDonChiTiet hdct) {
        return repo.delete(hdct);
    }

    @Override
    public HoaDonChiTiet getobjbyId(int id) {
        return repo.getObjById(id);
    }

    @Override
    public List<HoaDonChiTiet> findByMa(String ma) {
        return repo.findByMa(ma);
    }

    @Override
    public HoaDonChiTiet getobj(int idSP, int idHD) {
        return repo.getObj(idSP, idHD);
    }

    @Override
    public List<HoaDonChiTiet> getDoanhThu(int trangThai, Date ngayThanhToan) {
        return repo.getDoanhThu(trangThai, ngayThanhToan);
    }

    @Override
    public List<HoaDonChiTiet> findByTT(int trangThaiHD) {
        return repo.findByTT(trangThaiHD);
    }

    @Override
    public List<HoaDonChiTiet> findByTTHDCT(int trangThaiHDCT) {
        return repo.findByTTHDCT(trangThaiHDCT);
    }

}
