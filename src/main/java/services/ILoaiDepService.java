/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.LoaiDep;

/**
 *
 * @author homna
 */
public interface ILoaiDepService {
    List<LoaiDep> getAll();

    boolean save(LoaiDep ld);

    LoaiDep getObj(String ma);
}
