package services;

import java.util.List;
import models.ChiTietDep;

/**
 *
 * @author VU NGUYEN HUONG
 */
public interface IChiTietDepService {
    List<ChiTietDep> getAll();
    boolean save(ChiTietDep ctd);
    boolean delete(ChiTietDep ctd);
    ChiTietDep getObj(int id);
    List<ChiTietDep> findByName(String ten);
}
