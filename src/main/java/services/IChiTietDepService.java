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

//    List<ChiTietDep> findByName(String ten);

    List<ChiTietDep> findByTT(int trangThai, String ten);
    
//    List<ChiTietDep> pagination(int pageNumber, int pageSize);
    
    ChiTietDep getObjByProperties(int idDep, int idLoaiDep, int idMauSac, int idChatLieu, int idNSX, int idSize);
    
    List<ChiTietDep> findSLSPLess(int soLuong);
    
    List<ChiTietDep> topSPBanChay(int firstResult,int maxResult);
    
//    List<ChiTietDep> filter(String tenDep, String tenMauSac);
    
    List<ChiTietDep> test(int pageNumber, int pageSize, String tenDep, String tenLoaiDep, String tenMauSac, String tenChatLieu);
}
