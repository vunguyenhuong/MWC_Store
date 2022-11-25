package services;

import java.util.List;
import models.NguoiDung;

/**
 *
 * @author VU NGUYEN HUONG
 */
public interface INguoiDungService {
     
    List<NguoiDung> getListNhanVien(String ma);
    
    List<NguoiDung> findByName(String ma,String ten);
    
    List<NguoiDung> getAll();

    boolean save(NguoiDung nd);

    boolean delete(NguoiDung nd);

    NguoiDung getObj(String ma);
    
    List<NguoiDung> pagination(String ma, int pageNumber, int pageSize);
}
