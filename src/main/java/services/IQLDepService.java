package services;

import customModel.CTDepCustom;
import java.util.List;

/**
 *
 * @author VU NGUYEN HUONG
 */
public interface IQLDepService {

    List<CTDepCustom> getAll();

    boolean save(CTDepCustom ctdc);

    boolean delete(CTDepCustom ctdc);

    List<CTDepCustom> findByName(String ten);

    CTDepCustom getObjById(int id);
}