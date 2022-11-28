package services;

import java.util.List;
import models.KhachHang;

public interface IKhachHangService {

    List<KhachHang> getAll();

    boolean save(KhachHang kh);

    boolean delete(KhachHang kh);

    KhachHang getObj(String ma);

    KhachHang getObjectById(int id);

    List<KhachHang> findByName(String ten);

    List<KhachHang> pagination(int pageNumber, int pageSize, String ten);

}
