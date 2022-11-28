package services.impl;

import java.util.List;
import models.MauSac;
import repositories.MauSacRepository;
import services.IMauSacService;

/**
 *
 * @author tt
 */
public class MauSacService implements IMauSacService {

    private MauSacRepository repo;

    public MauSacService() {
        repo = new MauSacRepository();
    }

    @Override
    public List<MauSac> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean save(MauSac ms) {
        return repo.save(ms);
    }

    @Override
    public MauSac getObj(String ma) {
        return repo.getObj(ma);
    }

    @Override
    public List<MauSac> findByName(String ten) {
        return repo.findByName(ten);
    }

    @Override
    public MauSac getObjectById(int id) {
        return repo.getObjectById(id);
    }

    @Override
    public List<MauSac> pagination(int pageNumber, int pageSize, String ten) {
        return repo.pagination(pageNumber, pageSize, ten);
    }

}
