/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adpl.praktikumadpl4_solid1.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abe.dann
 */

//[SRP]
public class KendaraanRepository {
    private final List<Kendaraan> data = new ArrayList<>();
    
    public void tambah(Kendaraan kendaraan){
        data.add(kendaraan);
    }
    
    public List<Kendaraan> semua(){
        return new ArrayList<>(data);
    }
    
    public Kendaraan cariByPlat(String platNomor){
        for (Kendaraan k : data) {
            if(k.getPlatNomor().equalsIgnoreCase(platNomor));
            return k;
        }
        return null;
    }
}
