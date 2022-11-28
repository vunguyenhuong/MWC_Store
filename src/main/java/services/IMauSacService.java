package services;

import java.util.List;
import models.MauSac;

/**
 *
 * @author tt
 */
public interface IMauSacService {

    List<MauSac> getAll();

    boolean save(MauSac ms);

    MauSac getObj(String ma);

    MauSac getObjectById(int id);

    List<MauSac> findByName(String ten);

    List<MauSac> pagination(int pageNumber, int pageSize);
    
    List<MauSac> pagination1(int pageNumber, int pageSize, String ten);
}
