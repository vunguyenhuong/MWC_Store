package services.impl;

import java.util.List;
import models.Size;
import repositories.SizeRepository;
import services.ISizeService;

/**
 *
 * @author cvdoa
 */
public class SizeService implements ISizeService {

    private SizeRepository repo = new SizeRepository();

    @Override
    public List<Size> getListSize() {
        return repo.getAll();
    }

    @Override
    public boolean save(Size s) {
        return repo.save(s);
    }

    @Override
    public boolean delete(Size s) {
        return repo.delete(s);
    }

    @Override
    public Size getObj(String ma) {
        return repo.getObject(ma);
    }

    @Override
    public List<Size> findByName(Float ten) {
        return repo.findByName(ten);
    }

    @Override
    public Size getObjById(int id) {
        return repo.getObjById(id);
    }

    @Override
    public List<Size> pagination(int pageNumber, int pageSize) {
        return repo.pagination(pageNumber, pageSize);
    }

}
