package services;

import java.util.List;
import models.*;

/**
 *
 * @author VU NGUYEN HUONG
 */
public interface IQLSanPhamService {
    
    // Dép
    List<Dep> getAllDep();
    boolean saveDep(Dep obj);
    boolean deleteDep(Dep obj);
    Dep getObjDep(String ma);
    
    // Loại dép
    List<LoaiDep> getAllLoaiDep();
    boolean saveLoaiDep(LoaiDep obj);
    boolean deleteLoaiDep(LoaiDep obj);
    LoaiDep getObjLoaiDep(String ma);
    
    
    // Chất liệu
    List<ChatLieu> getAllChatLieu();
    boolean saveChatLieu(ChatLieu obj);
    boolean deleteChatLieu(ChatLieu obj);
    ChatLieu getObjChatLieu(String ma);
    
    
    // Màu sắc
    List<MauSac> getAllMauSac();
    boolean saveMauSac(MauSac obj);
    boolean deleteMauSac(MauSac obj);
    MauSac getObjMauSac(String ma);
    
    
    // Size
    List<Size> getAllSize();
    boolean saveSize(Size obj);
    boolean deleteSize(Size obj);
    Size getObjSize(String ma);
    
    
    // NSX
    List<NhaSX> getAllNSX();
    boolean saveNSX(NhaSX obj);
    boolean deleteNSX(NhaSX obj);
    NhaSX getObjNSX(String ma);
}
