/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adpl.praktikumadpl4_solid1.app;

import com.adpl.praktikumadpl4_solid1.controller.RentalController;
import com.adpl.praktikumadpl4_solid1.model.Kendaraan;

/**
 *
 * @author Abe.dann
 */
public class Main {
    public static void main(String[] args) {
        RentalController controller = new RentalController();
        
        //Data awal
        controller.tambahDataAwal(new Kendaraan(
                "B 1234 KKK", 
                "Toyota Alphard", 
                "MOBIL", 
                350000));
        controller.tambahDataAwal(new Kendaraan(
                "B 6789 KKK", 
                "Toyota Supra", 
                "MOBIL", 
                450000));
        controller.tambahDataAwal(new Kendaraan(
                "B 1234 KKK", 
                "Nissan GTR", 
                "MOBIL", 
                550000));
        controller.tambahDataAwal(new Kendaraan(
                "B 1234 KKK", 
                "Honda NSX", 
                "MOBIL", 
                650000));
        controller.jalankan();
    }
}
