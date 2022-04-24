/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang.barang;

import gudang.database.DatabaseClient;
import gudang.database.DatabaseMethod;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Farhan Fadila
 */
public class BarangClient  extends DatabaseClient implements DatabaseMethod<Barang> {
     final String tableName = "barang";
     
     public BarangClient() {
         if(con == null) {
             start();
         }
     }

    @Override
    public Barang get(String id) {
       Barang temp = null;
       ResultSet result = executeQuery("SELECT * FROM " + tableName + " WHERE kode_barang = " + id);

        try {
           if(result.next()) {
                temp = new Barang(result.getString(1), result.getString(2), result.getString(3), result.getLong(4),result.getLong(5));
           }
         } catch (SQLException ex) {
           Logger.getLogger(BarangClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    @Override
    public List<Barang> getList() {
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Barang> getAll() {
        List<Barang> temp = new ArrayList<>();
        
        ResultSet result = executeQuery("SELECT * FROM " + tableName);

        try {
            while(result.next()) {
               temp.add(new Barang(result.getString(1), result.getString(2), result.getString(3), result.getLong(4),result.getLong(5)));
            }
        } catch (SQLException ex) {
           Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    @Override
    public void create(Barang object) {
        Object[] temp = {object.kode, object.nama, object.jenis, object.hargaBeli, object.hargaJual};
         System.out.println(object.hargaJual);
        String query = "INSERT INTO  " + tableName + " (kode_barang, nama_barang, jenis_barang, harga_beli, harga_jual) VALUES " + objectToString(temp);
        System.out.println(query);
//        executeQuery2(query);
    }

    @Override
    public void delete(String id) {
         executeQuery2("DELETE FROM " + tableName + " WHERE kode_barang = " + id);
    }
}
