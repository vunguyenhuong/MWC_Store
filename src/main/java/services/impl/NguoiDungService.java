package services.impl;

import java.util.List;
import models.NguoiDung;
import repositories.NguoiDungRepository;
import services.INguoiDungService;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class NguoiDungService implements INguoiDungService {

    private NguoiDungRepository repo = new NguoiDungRepository();

    @Override
    public List<NguoiDung> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean save(NguoiDung nd) {
        return repo.save(nd);
    }

    @Override
    public boolean delete(NguoiDung nd) {
        return repo.delete(nd);
    }

    @Override
    public NguoiDung getObj(String ma) {
        return repo.getObj(ma);
    }

    @Override
    public List<NguoiDung> getListNhanVien(String ma) {
        return repo.getListNhanVien(ma);
    }

    @Override
    public List<NguoiDung> findByName(String ma, String ten) {
        return repo.findByName(ma, ten);
    }

   

}
