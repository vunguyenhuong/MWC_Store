package services;

import java.util.List;
import models.ChatLieu;
import models.ChiTietDep;
import models.Dep;
import models.LoaiDep;
import models.MauSac;
import models.NhaSX;
import models.Size;

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

    List<ChiTietDep> findByTT(int trangThai, String ten);
    
    List<ChiTietDep> pagination(int pageNumber, int pageSize);
    
}
