package services.impl;

import java.util.List;
import models.Dep;
import repositories.DepRepository;
import services.IDepService;

/**
 *
 * @author dell
 */
public class DepService implements IDepService {

    private DepRepository depRepository;
    
    public DepService() {
        this.depRepository = new DepRepository();
    }
    
    @Override
    public List<Dep> getList() {
        return this.depRepository.getAll();
    }
    
    @Override
    public boolean save(Dep dep) {
        return this.depRepository.save(dep);
    }
    
    @Override
    public Dep getObj(String ma) {
        return this.depRepository.getObj(ma);
    }

    @Override
    public List<Dep> getObjByName(String ten) {
        return this.depRepository.findByName(ten);
    }
    
    @Override
    public Dep getObjById(int id) {
        return depRepository.getObjById(id);
    }
    
}
