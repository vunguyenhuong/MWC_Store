package services.impl;

import java.util.List;
import models.Dep;
import repositories.DepRepository;
import services.IDepService;

/**
 *
 * @author dell
 */
public class DepService implements IDepService{
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
    public Dep getByMa(String ma) {
        return this.depRepository.getById(ma);
    }

    
}
