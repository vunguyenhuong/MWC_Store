package services.impl;

import java.util.List;
import models.NhaSX;
import repositories.NhaSXRepository;
import services.INhaSXService;

/**
 *
 * @author pc
 */
public class NhaSXService implements INhaSXService{
     private NhaSXRepository repo = new NhaSXRepository();

    @Override
    public List<NhaSX> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean save(NhaSX nsx) {
        return repo.save(nsx);
    }

    @Override
    public boolean delete(NhaSX nsx) {
        return repo.delete(nsx);
    }

    @Override
    public NhaSX getObj(String ma) {
        return repo.getObj(ma);
    }

    @Override
    public List<NhaSX> findByName(String ten) {
        return repo.findByName(ten);
    }
}
