
package Dao;

import Araclar.VTBaglanti;

import Nesneler.Uretici;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cem
 */
public class UreticiDAO extends VTBaglanti {

    

    public String bul(int id) {
        Uretici q = null;
        String ureticiad;

        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select * from uretici where id=" + id);
            rs.next();
            q = new Uretici();
            q.setId(rs.getInt("id"));
            q.setAd(rs.getString("ad"));
            q.setAdres(rs.getString("adres"));
            q.setTlf(rs.getString("tlf"));
            q.setAlacak(rs.getInt("alacak"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ureticiad = q.getAd();
        return ureticiad;

    }

    public void ekle(Uretici u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("insert into uretici (ad,adres,tlf) values('" + u.getAd() + "','" + u.getAdres() + "','" + u.getTlf() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Uretici> oku() {
        List<Uretici> liste = new ArrayList<>();
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select * from uretici order by id");

            while (rs.next()) {
                Uretici tmp = new Uretici(rs.getInt("id"), rs.getString("ad"), rs.getString("adres"), rs.getString("tlf"), rs.getInt("alacak"));
                liste.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

    public void guncelle(Uretici u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update uretici set ad='" + u.getAd() + "', adres='" + u.getAdres() + "', tlf='" + u.getTlf() + "' where id=" + u.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Uretici u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("delete from uretici where id=" + u.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
