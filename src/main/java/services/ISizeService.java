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
    
    Size getObject(String ma);
    
    List<Size> getSearch(String ten);
}
