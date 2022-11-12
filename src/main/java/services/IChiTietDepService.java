package services;

import java.util.List;
import models.*;

/**
 *
 * @author VU NGUYEN HUONG
 */
public interface IChiTietDepService {

    List<ChiTietDep> getAll();

    List<Dep> getAllDep();

    List<LoaiDep> getAllLoaiDep();

    List<ChatLieu> getAllChatLieu();

    List<MauSac> getAllMauSac();

    List<Size> getAllSize();

    List<NhaSX> getAllNSX();

    boolean save(ChiTietDep ctd);

    boolean delete(ChiTietDep ctd);

    ChiTietDep getObj(int id);

    List<ChiTietDep> findByName(String ten);
}
