package services;

import java.util.List;
import models.NhaSX;

/**
 *
 * @author pc
 */
public interface INhaSXService {

    List<NhaSX> getAll();

    List<NhaSX> search(String ma);

    boolean save(NhaSX nsx);

    boolean delete(NhaSX nsx);

    NhaSX getObj(String ma);
}
