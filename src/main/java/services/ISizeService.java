package services;

import java.util.List;
import models.Size;

/**
 *
 * @author cvdoa
 */
public interface ISizeService {
    List<Size> getListSize();
    
    boolean save(Size s);
    
    boolean delete(Size s);
    
    Size getObj(String ma);
    
    List<Size> findByName(Float ten);
    
    Size getObjById(int id);

    List<Size> pagination(int pageNumber, int pageSize);
}
