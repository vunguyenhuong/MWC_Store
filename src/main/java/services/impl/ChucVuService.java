package services.impl;

import java.util.List;
import models.ChucVu;
import repositories.ChucVuRepository;
import services.IChucVuService;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class ChucVuService implements IChucVuService {

    private ChucVuRepository repo = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return repo.getAll();
    }

}
