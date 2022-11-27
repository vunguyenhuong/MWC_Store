package services;

import java.util.List;
import models.NhaSX;

/**
 *
 * @author pc
 */
public interface INhaSXService {

    List<NhaSX> getAll();

    List<NhaSX> findByName(String ten);

    boolean save(NhaSX nsx);

    boolean delete(NhaSX nsx);

    NhaSX getObj(String ma);
    
    NhaSX getObjById(int id);
    
    List<NhaSX> pagination(int pageNumber, int pageSize);
}
