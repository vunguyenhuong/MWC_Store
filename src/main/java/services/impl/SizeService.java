package services.impl;

import java.util.ArrayList;
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
    public Size getObject(String ma) {
        return repo.getObject(ma);
    }

    @Override
    public List<Size> getSearch(String ten) {
        return repo.getSearch(ten);
    }

}
