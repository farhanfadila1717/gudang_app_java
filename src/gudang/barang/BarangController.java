/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang.barang;

import gudang.database.DatabaseMethod;
import java.util.List;

/**
 *
 * @author Farhan Fadila
 */
public class BarangController implements DatabaseMethod<Barang> {
    
    BarangClient client = null;
    
    public BarangController() {
        if(client == null) {
            client = new BarangClient();
        }
    }

    @Override
    public Barang get(String id) {
        return client.get(id);
    }

    @Override
    public List<Barang> getList() {
        return client.getList();
    }

    @Override
    public List<Barang> getAll() {
        return client.getAll();
    }

    @Override
    public void create(Barang object) {
        client.create(object);
    }

    @Override
    public void delete(String id) {
        client.delete(id);
    } 
}
