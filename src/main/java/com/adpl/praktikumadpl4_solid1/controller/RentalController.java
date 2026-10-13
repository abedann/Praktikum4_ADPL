/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adpl.praktikumadpl4_solid1.controller;

import com.adpl.praktikumadpl4_solid1.model.Kendaraan;
import com.adpl.praktikumadpl4_solid1.model.KendaraanFactory;
import com.adpl.praktikumadpl4_solid1.model.KendaraanRepository;
import com.adpl.praktikumadpl4_solid1.model.Penyewaan;
import com.adpl.praktikumadpl4_solid1.model.PenyewaanRepository;
import com.adpl.praktikumadpl4_solid1.view.RentalView;
import com.adpl.praktikumadpl4_solid1.view.StrukView;
import java.util.List;

/**
 *
 * @author Abe.dann
 */
//[SRP] Satu tanggung jawab: mengatur alur aplikasi
//menerima pilihan dari View, memvalidasi, memanggil Model, mengirim hasil ke View.
//Tidak menyimpan data sendiri, tidak memformat struk, tidak menghitung tarif.
public class RentalController {
    private final KendaraanRepository kendaraanRepo = new KendaraanRepository();
    private final PenyewaanRepository penyewaanRepo = new PenyewaanRepository();
    private final RentalView view = new RentalView();
    private final StrukView strukView = new StrukView();
    
    public void tambahDataAwal(Kendaraan kendaraan){
        kendaraanRepo.tambah(kendaraan);
    }
    
    public void jalankan(){
        while(true){
            String pilihan = view.tampilMenu();
            switch (pilihan){
                case "1" -> view.tampilDaftarKendaraan(kendaraanRepo.semua());
                case "2" -> tambahKendaraan();
                case "3" -> sewaKendaraan();
                case "4" -> kembalikanKendaraan();
                case "5" -> view.tampilkanRiwayat(penyewaanRepo.semua());
                case "0" -> {
                    view.tampilPesan("Thank You");
                    return;
                }
                default -> view.tampilPesan("Menu Tidak Ada");
            }
        }
    }
    
    public void tambahKendaraan(){
        String plat = view.bacaTeks("Plat Nomor");
        if (plat.isEmpty() || kendaraanRepo.cariByPlat(plat) != null){
            view.tampilPesan("Plat Nomor Kosong atau Telah Terdaftar");
            return;
        }
        String merk = view.bacaTeks("Merk");
        // [OCP] Daftar jenis diambil dari Factory, bukan ditulis manual di Controller.
        String jenis = view.bacaTeks("Jenis (" + String.join("/", KendaraanFactory.JENIS) + ")").toUpperCase();
            if (!List.of(KendaraanFactory.JENIS).contains(jenis)) {
            view.tampilPesan("Jenis tidak dikenal.");
            return;
        }
        long tarif = view.bacaAngka("Tarif per Hari");
        if(tarif<=0){
            view.tampilPesan("Tarif harus lebih dari 0.");
            return;
        }
        kendaraanRepo.tambah(KendaraanFactory.buat(jenis, plat, merk, tarif));
        view.tampilPesan("Kendaraan berhasil ditambahkan.");
    }
    
    public void sewaKendaraan(){
        String plat = view.bacaTeks("Plat Nomor");
        Kendaraan kendaraan = kendaraanRepo.cariByPlat(plat);
        if(kendaraan == null || !kendaraan.isTersedia()){
            System.out.println("Kendaraan Tidak Ditemukan atau Sedang Disewa");
            return;
        }
        String nama = view.bacaTeks("Nama Penyewa");
        int hari = (int)view.bacaAngka("Lama Sewa (hari)");
        //[LSP] Validasi memakai kontrak kelas induk, BUKAN instanceof MobilPremium.
        //      Berlaku sama untuk semua jenis, termasuk jenis yang dibuat nanti.
                if (hari < kendaraan.getMinimalHari()) {
                        view.tampilPesan(kendaraan.getMerk() + " minimal disewa "
                                + kendaraan.getMinimalHari() + " hari.");
            return;
        }
        
        //[OCP] Controller tidak tahu dan tidak perlu tahu jenis kendaraannya.
        //      Polimorfisme memilih hitungBiaya() milik subclass yang tepat.
        long total = kendaraan.hitungBiaya(hari);
        Penyewaan sewa = new Penyewaan(plat, nama, kendaraan, hari, total);
        penyewaanRepo.tambah(sewa);
        kendaraan.setTersedia(false);
        strukView.cetak(sewa);
    }
    
    public void kembalikanKendaraan(){
        String plat = view.bacaTeks("Plat Nomor");
        Penyewaan sewa = penyewaanRepo.cariAktifByPlat(plat);
        if(sewa==null){
            view.tampilPesan("Tidak Ada Penyewaan");
            return;
        }
        sewa.selesai();
        sewa.getKendaraan().setTersedia(true);
        view.tampilPesan("Kendaraan " + sewa.getKendaraan().getMerk() + " telah dikembalikan");
    }
}
