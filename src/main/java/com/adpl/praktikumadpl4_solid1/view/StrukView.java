/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adpl.praktikumadpl4_solid1.view;

import com.adpl.praktikumadpl4_solid1.model.Penyewaan;

/**
 *
 * @author Abe.dann
 */

//[SRP] satu tanggung jawab: format tampilan struk sewa.
public class StrukView {
    public void cetak(Penyewaan p){
        System.out.println("------ STRUK SEWA ------");
        System.out.println("No. Sewa    : " + p.getId());
        System.out.println("Penyewa     : " + p.getNamaPenyewa());
        System.out.println("Kendaraan   : " + p.getKendaraan().getMerk() + " (" + p.getKendaraan().getPlatNomor() + ")");
        System.out.println("Jenis       : " + p.getKendaraan().getMerk());
        System.out.println("Lama Sewa   : " + p.getLamaHari() + " hari");
        System.out.println("Total       : " + Format.rupiah(p.getTotalBiaya()));
        System.out.println("------ STRUK SEWA ------");
    }
}
