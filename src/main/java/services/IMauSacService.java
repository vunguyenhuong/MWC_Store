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

    List<MauSac> findByName(String ten);
}
