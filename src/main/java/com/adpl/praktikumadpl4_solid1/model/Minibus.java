/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adpl.praktikumadpl4_solid1.model;

/**
 *
 * @author Abe.dann
 */

//[OCP] Bukti OCP: jenis baru ditambahkan sebagai kelas BARU.
//      Kendaraan, Controller, View, dan Repository tidak diubah sama sekali.
//
// Aturan Minibus: (tarif + biaya sopir Rp150.000) × hari.
public class Minibus extends Kendaraan {
        private static final long BIAYA_SOPIR_PER_HARI = 150000;

        public Minibus(String platNomor, String merk, long tarifPerHari) {
                super(platNomor, merk, tarifPerHari);
        }

        @Override
        public String getJenis() {
                return "MINIBUS";
        }

        @Override
        public long hitungBiaya(int hari) {
                return (getTarifPerHari() + BIAYA_SOPIR_PER_HARI) * hari;
        }
}
