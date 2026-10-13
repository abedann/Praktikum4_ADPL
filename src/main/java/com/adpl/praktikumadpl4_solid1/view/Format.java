/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adpl.praktikumadpl4_solid1.view;

import java.util.Locale;

/**
 *
 * @author Abe.dann
 */

//[SRP] m/format angka menjadi teks Rupiah
public class Format {
    public static String rupiah(long nilai){
        return String.format(Locale.US, "Rp%d", nilai).replace(",", ".");
    }
}
