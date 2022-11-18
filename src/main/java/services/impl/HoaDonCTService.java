package services.impl;

import java.util.ArrayList;
import java.util.List;
import models.ChiTietDep;
import models.HoaDon;
import models.HoaDonChiTiet;
import repositories.ChiTietDepRepository;
import repositories.HoaDonCTRepository;
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
    public List<HoaDonChiTiet> findByName(String ten) {
        return repo.findByName(ten);
    }

}
