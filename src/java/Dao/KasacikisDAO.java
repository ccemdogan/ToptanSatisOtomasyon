package Dao;

import Araclar.VTBaglanti;
import Nesneler.Kasacikis;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KasacikisDAO extends VTBaglanti {

    public void ekle(Kasacikis u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("insert into kasacikis (uretici_id,odeme,odeme_sekli) values(" + u.getUretici_Id() + "," + u.getOdeme() + ",'" + u.getOdeme_Sekli() + "')");
            st.executeUpdate("update merkez set kasa=kasa-" + u.getOdeme());
            st.executeUpdate("update uretici set alacak=alacak-" + u.getOdeme() + " where id=" + u.getUretici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Kasacikis> oku() {
        List<Kasacikis> liste = new ArrayList<>();
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select * from kasacikis order by id");

            while (rs.next()) {
                Kasacikis tmp = new Kasacikis(rs.getInt("id"), rs.getInt("uretici_id"), rs.getInt("odeme"), rs.getDate("tarih"), rs.getString("odeme_sekli"));
                liste.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

    public void guncelle(Kasacikis u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update kasacikis set uretici_id=" + u.getUretici_Id() + ", odeme=" + u.getOdeme() + ", odeme_sekli='" + u.getOdeme_Sekli() + "' where id=" + u.getId());
            st.executeUpdate("update merkez set kasa=kasa-" + u.getOdeme());
            st.executeUpdate("update uretici set alacak=alacak-" + u.getOdeme() + " where id=" + u.getUretici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Kasacikis u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("delete from kasacikis where id=" + u.getId());
            st.executeUpdate("update merkez set kasa=kasa+" + u.getOdeme());
            st.executeUpdate("update uretici set alacak=alacak+" + u.getOdeme() + " where id=" + u.getUretici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onceSil(Kasacikis u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update merkez set kasa=kasa+" + u.getOdeme());
            st.executeUpdate("update uretici set alacak=alacak+" + u.getOdeme() + " where id=" + u.getUretici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    
}
