/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adpl.praktikumadpl4_solid1.model;

/**
 *
 * @author Abe.dann
 */
/*
[LSP]   MobilPremium bisa menggantikan Kendaraan di mana pun tanpa crash.
        Syarat minimal 3 hari tidak lagi "disembunyikan" lewat exception,
        tetapi diumumkan melalui getMinimalHari() yang memang bagian dari kontrak induk

Pemilik rental ingin menambah Mobil Premium (misalnya Alphard) dengan dua aturan: 
- minimal disewa 3 hari, 
- dan ada asuransi premium tambahan Rp100.000
*/
public class MobilPremium extends Mobil {
        private static final long ASURANSI_PREMIUM = 100000;
        private static final int MINIMAL_HARI = 3;

        public MobilPremium(String platNomor, String merk, long tarifPerHari) {
                super(platNomor, merk, tarifPerHari);
        }

        @Override
        public String getJenis() {
                return "PREMIUM";
        }

        @Override
        public int getMinimalHari() {
                return MINIMAL_HARI;
        }

        //[LSP] hasil selalu biaya > 0 sesuai kontrak induk.
        @Override
        public long hitungBiaya(int hari) {
                return super.hitungBiaya(hari) + ASURANSI_PREMIUM;
        }
}
