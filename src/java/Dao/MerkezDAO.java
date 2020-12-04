package Dao;

import Araclar.VTBaglanti;
import Nesneler.Merkez;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MerkezDAO extends VTBaglanti {

    public List<Merkez> oku() {
        List<Merkez> liste = new ArrayList<>();
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select * from merkez");
            rs.next();
            Merkez tmp = new Merkez(rs.getString("ad"), rs.getString("adres"), rs.getString("tlf"), rs.getInt("kasa"));
            liste.add(tmp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

}
