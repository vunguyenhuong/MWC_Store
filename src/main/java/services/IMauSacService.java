/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.MauSac;

/**
 *
 * @author tt
 */
public interface IMauSacService {
    List<MauSac> getAllCV();
    boolean save(MauSac ms);
    MauSac getObj1(String ma);
}
