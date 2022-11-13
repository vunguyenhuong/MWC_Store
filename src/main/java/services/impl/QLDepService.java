package services.impl;

import customModel.CTDepCustom;
import java.util.ArrayList;
import java.util.List;
import models.ChiTietDep;
import repositories.ChatLieuRepository;
import repositories.ChiTietDepRepository;
import repositories.DepRepository;
import repositories.LoaiDepRepository;
import repositories.MauSacRepository;
import repositories.NhaSXRepository;
import repositories.SizeRepository;
import services.IQLDepService;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class QLDepService implements IQLDepService {
    
    private List<CTDepCustom> list;
    
    private ChiTietDepRepository repo;
    private DepRepository depRepo;
    private LoaiDepRepository loaiDepRepo;
    private ChatLieuRepository chatLieuRepo;
    private MauSacRepository mauSacRepo;
    private SizeRepository sizeRepo;
    private NhaSXRepository nsxRepo;

    public QLDepService() {
        repo = new ChiTietDepRepository();
        depRepo = new DepRepository();
        loaiDepRepo = new LoaiDepRepository();
        chatLieuRepo = new ChatLieuRepository();
        mauSacRepo = new MauSacRepository();
        sizeRepo = new SizeRepository();
        nsxRepo = new NhaSXRepository();
        list = new ArrayList<>();
    }
    
    @Override
    public List<CTDepCustom> getAll() {
        list = new ArrayList<>();
        for (ChiTietDep x : repo.getAll()) {
            list.add(new CTDepCustom(x,
                    depRepo.getObj(x.getDep().getMa()),
                    loaiDepRepo.getObj(x.getLoaiDep().getMa()),
                    chatLieuRepo.getObj(x.getChatLieu().getMa()),
                    mauSacRepo.getObj(x.getMauSac().getMa()),
                    sizeRepo.getObject(x.getSize().getMa()),
                    nsxRepo.getObj(x.getNhaSX().getMa())));
        }
        return list;
    }
    
    @Override
    public boolean save(CTDepCustom ctdc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean delete(CTDepCustom ctdc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<CTDepCustom> findByName(String ten) {
        list = new ArrayList<>();
        for (ChiTietDep x : repo.findByName(ten)) {
            list.add(new CTDepCustom(x,
                    depRepo.getObj(x.getDep().getMa()),
                    loaiDepRepo.getObj(x.getLoaiDep().getMa()),
                    chatLieuRepo.getObj(x.getChatLieu().getMa()),
                    mauSacRepo.getObj(x.getMauSac().getMa()),
                    sizeRepo.getObject(x.getSize().getMa()),
                    nsxRepo.getObj(x.getNhaSX().getMa())));
        }
        return list;
    }
    
    @Override
    public CTDepCustom getObjById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
