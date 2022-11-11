package services;

import java.util.List;
import models.Dep;

/**
 *
 * @author dell
 */
public interface IDepService {

    List<Dep> getList();

    boolean save(Dep dep);

    Dep getObj(String ma);
}
