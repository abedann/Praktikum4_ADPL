/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adpl.praktikumadpl4_solid1.app;

import com.adpl.praktikumadpl4_solid1.controller.RentalController;
import com.adpl.praktikumadpl4_solid1.model.Kendaraan;
import com.adpl.praktikumadpl4_solid1.model.Minibus;
import com.adpl.praktikumadpl4_solid1.model.Mobil;
import com.adpl.praktikumadpl4_solid1.model.Motor;

/**
 *
 * @author Abe.dann
 */
public class Main {
    public static void main(String[] args) {
        RentalController controller = new RentalController();
        
        //Data awal
        controller.tambahDataAwal(new Mobil(
                "B 1234 KKK", 
                "Toyota Alphard", 
                350000));
        controller.tambahDataAwal(new Mobil(
                "B 6789 KKK", 
                "Toyota Supra", 
                450000));
        controller.tambahDataAwal(new Motor(
                "B 1234 KKK", 
                "Honda CBR 250cc",  
                550000));
        controller.tambahDataAwal(new Minibus(
                "B 1234 KKK", 
                "Toyota Hiace",  
                900000));
        controller.jalankan();
    }
}
