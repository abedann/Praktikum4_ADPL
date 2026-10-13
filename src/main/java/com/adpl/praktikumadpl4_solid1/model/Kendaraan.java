/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adpl.praktikumadpl4_solid1.model;

/**
 *
 * @author Abe.dann
 */
public class Kendaraan {
    private final String platNomor;
    private final String merk;
    private final String jenis;
    private final long tarifPerHari;
    private boolean tersedia = true;
    
    public Kendaraan (String platNomor, String merk, String jenis, long tarifPerHari){
        this.platNomor = platNomor;
        this.merk = merk;
        this.jenis = jenis;
        this.tarifPerHari = tarifPerHari;
    }
    
    public long hitungBiaya(int hari){
        long total = tarifPerHari * hari;
        
        if (jenis.equals("MOBIL")){
            total += 50000;
        }else if(jenis.equals("MOTOR")){
            if(hari >= 7) total -= total / 10;
        }
        return total;
    }
    
    public String getPlatNomor(){
        return platNomor;
    }
    
    public String getMerk(){
        return merk;
    }
    
    public String getJenis(){
        return jenis;
    }
    
    public long getTarifPerHari(){
        return tarifPerHari;
    }
    
    public boolean isTersedia(){
        return tersedia;
    }
    
    public void setTersedia(boolean tersedia){
        this.tersedia = tersedia;
    }
}
