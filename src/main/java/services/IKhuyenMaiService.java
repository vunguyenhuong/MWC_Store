/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.KhuyenMai;

/**
 *
 * @author KimChi
 */
public interface IKhuyenMaiService {

    List<KhuyenMai> getAll();

    boolean save(KhuyenMai km);

    boolean delete(KhuyenMai km);

    KhuyenMai getObj(String ma);

    KhuyenMai getObjectById(int id);

    List<KhuyenMai> findByName(String ten);
}
