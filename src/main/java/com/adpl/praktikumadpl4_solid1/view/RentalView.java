/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adpl.praktikumadpl4_solid1.view;

import com.adpl.praktikumadpl4_solid1.model.Kendaraan;
import com.adpl.praktikumadpl4_solid1.model.Penyewaan;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Abe.dann
 */
public class RentalView {
    private final Scanner input = new Scanner(System.in);
    
    public String tampilMenu(){
        System.out.println("");
        System.out.println("====== RENTAL KENDARAAN ======");
        System.out.println("1. Lihat Daftar Kendaraan");
        System.out.println("2. Tambah Kendaraan");
        System.out.println("3. Sewa Kendaraan");
        System.out.println("4. Kembalikan Kendaraan");
        System.out.println("5. Riwayat Pesanan");
        System.out.println("0. Keluar");
        return bacaTeks("Pilih Menu");
    }
    
    public void tampilDaftarKendaraan(List<Kendaraan> daftar){
        System.out.println("====== Daftar Kendaraan ======");
        if(daftar.isEmpty()){
            System.out.println("Belum Ada Kendaraan");
            return;
        }
        
        for(Kendaraan k : daftar){
            System.out.println(k.getPlatNomor() + " | " + k.getMerk() + " | " + k.getJenis() + " | " + Format.rupiah(k.getTarifPerHari()) + " | " + (k.isTersedia() ? "Tersedia" : "Disewa"));
        }
    }
    
    public void tampilkanRiwayat(List<Penyewaan> daftar){
        System.out.println("====== Riwayat Kendaraan ======");
        if(daftar.isEmpty()){
            System.out.println("Belum Ada Penyewaan");
            return;
        }
        
        for(Penyewaan p : daftar){
            System.out.println(
                    p.getId() + " | " + p.getNamaPenyewa() + " | " + p.getKendaraan().getMerk() + " | " + p.getLamaHari() + " | " + Format.rupiah(p.getTotalBiaya()) + " | " + (p.isAktif() ? "Berjalan" : "Selesai"));
        }
    }
    
    public String bacaTeks(String label){
        System.out.println("Pilihan " + ": ");
        return input.nextLine().trim();
        
    }
    
    public long bacaAngka(String label){
        while(true){
            String teks = bacaTeks(label);
            try{
                return Long.parseLong(teks);
            }catch (NumberFormatException e){
                tampilPesan("Input Harus Berupa Angka");
            }
        }
    }
    
    public void tampilPesan(String pesan){
        System.out.println(">> " + pesan);
    }
}
