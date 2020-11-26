package Dao;

import Araclar.VTBaglanti;
import Nesneler.Satici;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SaticiDAO extends VTBaglanti {
    
         public String bul(int id) {
        Satici q = null;
        String saticiad;

        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select * from satici where id=" + id);
            rs.next();
            q = new Satici();
            q.setId(rs.getInt("id"));
            q.setAd(rs.getString("ad"));
            q.setAdres(rs.getString("adres"));
            q.setTlf(rs.getString("tlf"));
            q.setBorc(rs.getInt("borc"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        saticiad=q.getAd();
        return saticiad;

    }


    public void ekle(Satici u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("insert into satici (ad,adres,tlf) values('" + u.getAd() + "','" + u.getAdres() + "','" + u.getTlf() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Satici> oku() {
        List<Satici> liste = new ArrayList<>();
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select * from satici order by id");

            while (rs.next()) {
                Satici tmp = new Satici(rs.getInt("id"), rs.getString("ad"), rs.getString("adres"), rs.getString("tlf"), rs.getInt("borc"));
                liste.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

    public void guncelle(Satici u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update satici set ad='" + u.getAd() + "', adres='" + u.getAdres() + "', tlf='" + u.getTlf() + "' where id=" + u.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Satici u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("delete from satici where id=" + u.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
