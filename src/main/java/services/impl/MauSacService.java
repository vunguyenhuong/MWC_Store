/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import models.MauSac;
import repositories.MauSauRepository;
import services.IMauSacService;

/**
 *
 * @author tt
 */
public class MauSacService implements IMauSacService{
    private MauSauRepository repo;

    public MauSacService() {
        repo  = new MauSauRepository();
    }
    
    @Override
    public List<MauSac> getAllCV() {
        return repo.getAllCV();
    }

    @Override
    public boolean save(MauSac ms) {
        return repo.save(ms);
    }

    @Override
    public MauSac getObj1(String ma) {
        return repo.getObj(ma);
    }
    
    
    

   
    
}
