/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import models.KhachHang;
import repositories.KhachHangRepository;
import services.IKhachHangService;

/**
 *
 * @author homna
 */
public class KhachHangService implements IKhachHangService{

    private KhachHangRepository repo = new KhachHangRepository();
    
    @Override
    public List<KhachHang> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean save(KhachHang kh) {
        return repo.save(kh);
    }

    @Override
    public boolean delete(KhachHang kh) {
        return repo.delete(kh);
    }

    @Override
    public KhachHang getObj(String ma) {
        return repo.getObj(ma);
    }

    @Override
    public KhachHang getObjectById(int id) {
        return repo.getObjectById(id);
    }

    @Override
    public List<KhachHang> findByName(String ten) {
        return repo.findByName(ten);
    }
    
}
