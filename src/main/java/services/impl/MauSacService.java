
package services.impl;

import java.util.List;
import models.MauSac;
import repositories.MauSacRepository;
import services.IMauSacService;

/**
 *
 * @author tt
 */
public class MauSacService implements IMauSacService{
    private MauSacRepository repo;

    public MauSacService() {
        repo  = new MauSacRepository();
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
    
    
    

   
    
}
