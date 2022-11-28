package services.impl;

import java.util.List;
import models.LoaiDep;
import repositories.LoaiDepRepository;
import services.ILoaiDepService;

/**
 *
 * @author homna
 */
public class LoaiDepService implements ILoaiDepService {
    
    private LoaiDepRepository loaiDepRepository = new LoaiDepRepository();
    
    @Override
    public List<LoaiDep> getAll() {
        return loaiDepRepository.getAll();
    }
    
    @Override
    public boolean save(LoaiDep ld) {
        return loaiDepRepository.save(ld);
    }
    
    @Override
    public LoaiDep getObj(String ma) {
        return loaiDepRepository.getObj(ma);
    }
    
    @Override
    public List<LoaiDep> findByName(String ten) {
        return loaiDepRepository.findByName(ten);
    }
    
    @Override
    public LoaiDep getObjectById(int id) {
        return loaiDepRepository.getObjectById(id);
    }
    
    @Override
    public List<LoaiDep> pagination(int pageNumber, int pageSize, String ten) {
        return loaiDepRepository.pagination(pageNumber, pageSize, ten);
    }
    
}
