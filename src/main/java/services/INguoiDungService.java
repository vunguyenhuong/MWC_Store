package services;

import java.util.List;
import models.NguoiDung;

/**
 *
 * @author VU NGUYEN HUONG
 */
public interface INguoiDungService {

    List<NguoiDung> getAll();

    boolean save(NguoiDung nd);

    boolean delete(NguoiDung nd);

    NguoiDung getObj(String ma);
}
