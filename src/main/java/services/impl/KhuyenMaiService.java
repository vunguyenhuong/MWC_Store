package services.impl;

import java.util.List;
import models.KhuyenMai;
import repositories.KhuyenMaiRepository;
import services.IKhuyenMaiService;

/**
 *
 * @author KimChi
 */
public class KhuyenMaiService implements IKhuyenMaiService{
    private KhuyenMaiRepository repo = new KhuyenMaiRepository();
    @Override
    public List<KhuyenMai> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean save(KhuyenMai km) {
         return repo.save(km);
    }

    @Override
    public boolean delete(KhuyenMai km) {
         return repo.delete(km);
    }

    @Override
    public KhuyenMai getObj(String ma) {
         return repo.getObj(ma);
    }

    @Override
    public KhuyenMai getObjectById(int id) {
        return repo.getObjectById(id);
    }

    @Override
    public List<KhuyenMai> findByName(String ten) {
         return repo.findByName(ten);
    }

    @Override
    public List<KhuyenMai> pagination(int pageNumber, int pageSize, String ten) {
        return repo.pagination(pageNumber, pageSize, ten);
    }
    
}
