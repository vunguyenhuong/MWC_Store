package services.impl;

import java.util.List;
import models.ChiTietDep;
import repositories.ChiTietDepRepository;
import services.IChiTietDepService;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class ChiTietDepService implements IChiTietDepService {

    private ChiTietDepRepository repo = new ChiTietDepRepository();

    @Override
    public List<ChiTietDep> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean save(ChiTietDep ctd) {
        return repo.save(ctd);
    }

    @Override
    public boolean delete(ChiTietDep ctd) {
        return repo.delete(ctd);
    }

    @Override
    public ChiTietDep getObj(int id) {
        return repo.getObjById(id);
    }

    @Override
    public List<ChiTietDep> findByName(String ten) {
        return repo.findByName(ten);
    }

}
