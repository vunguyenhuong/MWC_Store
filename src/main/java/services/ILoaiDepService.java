package services;

import java.util.List;
import models.LoaiDep;

/**
 *
 * @author homna
 */
public interface ILoaiDepService {

    List<LoaiDep> getAll();

    boolean save(LoaiDep ld);

    LoaiDep getObj(String ma);

    LoaiDep getObjectById(int id);

    List<LoaiDep> findByName(String ten);
    
    List<LoaiDep> pagination(int pageNumber, int pageSize);
}
