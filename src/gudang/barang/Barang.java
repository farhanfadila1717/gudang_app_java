/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang.barang;


/**
 *
 * @author Farhan Fadila
 */
public class Barang  {
     String kode;
     String nama;
     String jenis;
     long hargaBeli;
     long hargaJual;
     
     public Barang(String kode, String nama, String jenis, long hargaBeli, long hargaJual) {
         this.kode = kode;
         this.nama = nama;
         this.jenis = jenis;
         this.hargaBeli = hargaBeli;
         this.hargaJual = hargaJual;
    }
}
