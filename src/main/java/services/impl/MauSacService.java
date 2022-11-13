/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import models.MauSac;
import repositories.MauSacRepository;
import services.IMauSacService;

/**
 *
 * @author tt
 */
public class MauSacService implements IMauSacService {

    private MauSacRepository repo;

    public MauSacService() {
        repo = new MauSacRepository();
    }

    @Override
    public List<MauSac> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean save(MauSac ms) {
        return repo.save(ms);
    }

    @Override
    public MauSac getObj(String ma) {
        return repo.getObj(ma);
    }

    @Override
    public List<MauSac> findByName(String ten) {
        return repo.findByName(ten);
    }

}
