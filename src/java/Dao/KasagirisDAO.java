package Dao;

import Araclar.VTBaglanti;
import Nesneler.Kasagiris;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KasagirisDAO extends VTBaglanti {

    public void ekle(Kasagiris u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("insert into kasagiris (satici_id,tahsilat,tahsilat_sekli) values(" + u.getSatici_Id() + "," + u.getTahsilat() + ",'" + u.getTahsilat_Sekli() + "')");
            st.executeUpdate("update merkez set kasa=kasa+" + u.getTahsilat());
            st.executeUpdate("update satici set borc=borc-" + u.getTahsilat() + " where id=" + u.getSatici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Kasagiris> oku() {
        List<Kasagiris> liste = new ArrayList<>();
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select * from kasagiris order by id");

            while (rs.next()) {
                Kasagiris tmp = new Kasagiris(rs.getInt("id"), rs.getInt("satici_id"), rs.getInt("tahsilat"), rs.getDate("tarih"), rs.getString("tahsilat_sekli"));
                liste.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

    public void guncelle(Kasagiris u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update kasagiris set satici_id=" + u.getSatici_Id() + ", tahsilat=" + u.getTahsilat() + ", tahsilat_sekli='" + u.getTahsilat_Sekli() + "' where id=" + u.getId());
            st.executeUpdate("update merkez set kasa=kasa+" + u.getTahsilat());
            st.executeUpdate("update satici set borc=borc-" + u.getTahsilat() + " where id=" + u.getSatici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Kasagiris u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("delete from kasagiris where id=" + u.getId());
            st.executeUpdate("update merkez set kasa=kasa-" + u.getTahsilat());
            st.executeUpdate("update satici set borc=borc+" + u.getTahsilat() + " where id=" + u.getSatici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onceSil(Kasagiris u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update merkez set kasa=kasa-" + u.getTahsilat());
            st.executeUpdate("update satici set borc=borc+" + u.getTahsilat() + " where id=" + u.getSatici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
