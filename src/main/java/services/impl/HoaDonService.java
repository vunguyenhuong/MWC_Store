/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.Date;
import java.util.List;
import models.HoaDon;
import repositories.HoaDonRepository;
import services.IHoaDonService;

/**
 *
 * @author tt
 */
public class HoaDonService implements IHoaDonService{
    
    private HoaDonRepository hoadonRepo = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        return hoadonRepo.getAll();
    }

    @Override
    public boolean save(HoaDon hd) {
        return hoadonRepo.save(hd);
    }

    @Override
    public boolean delete(HoaDon hd) {
        return hoadonRepo.delete(hd);
    }

    @Override
    public HoaDon getObj(String ma) {
        return hoadonRepo.getObj(ma);
    }

    @Override
    public HoaDon getObjById(int id) {
        return hoadonRepo.getObjById(id);
    }

    @Override
    public List<HoaDon> findByName(String ma) {
        return hoadonRepo.findByName(ma);
    }

    @Override
    public List<HoaDon> findByMaAndTen(String ten) {
        return hoadonRepo.getObjByMaAndKH(ten);
    }

    @Override
    public List<HoaDon> getKHByTen() {
        return hoadonRepo.getHDByTT();
    }

    @Override
    public List<HoaDon> getKHByTen1() {
        return hoadonRepo.getHDByTT1();
    }

    @Override
    public List<HoaDon> getHDByTT(int trangthai, String type, Date from, Date to) {
        return hoadonRepo.getHDByTT2(trangthai, type, from, to);
    }
    
    
    
    
}
