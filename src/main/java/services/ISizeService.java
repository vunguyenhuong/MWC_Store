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
    
    List<Size> findByName(String ten);
    
    Size getObjById(int id);
}
