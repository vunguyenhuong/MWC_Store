package services.impl;

import java.util.List;
import models.*;
import repositories.*;
import services.IChiTietDepService;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class ChiTietDepService implements IChiTietDepService {

    private ChiTietDepRepository repo = new ChiTietDepRepository();
    private DepRepository depRepo = new DepRepository();
    private LoaiDepRepository loaiDepRepo = new LoaiDepRepository();
    private ChatLieuRepository chatLieuRepo = new ChatLieuRepository();
    private MauSacRepository mauSacRepo = new MauSacRepository();
    private SizeRepository sizeRepo = new SizeRepository();
    private NhaSXRepository nsxRepo = new NhaSXRepository();

    @Override
    public List<ChiTietDep> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean save(ChiTietDep ctd) {
        return repo.save(ctd);
    }

    @Override
    public boolean delete(ChiTietDep ctd) {
        return repo.delete(ctd);
    }

    @Override
    public ChiTietDep getObj(int id) {
        return repo.getObjById(id);
    }

    @Override
    public List<ChiTietDep> findByName(String ten) {
        return repo.findByName(ten);
    }

    @Override
    public List<Dep> getAllDep() {
        return depRepo.getAll();
    }

    @Override
    public List<LoaiDep> getAllLoaiDep() {
        return loaiDepRepo.getAll();
    }

    @Override
    public List<ChatLieu> getAllChatLieu() {
        return chatLieuRepo.getAll();
    }

    @Override
    public List<MauSac> getAllMauSac() {
        return mauSacRepo.getAll();
    }

    @Override
    public List<Size> getAllSize() {
        return sizeRepo.getAll();
    }

    @Override
    public List<NhaSX> getAllNSX() {
        return nsxRepo.getAll();
    }
}
