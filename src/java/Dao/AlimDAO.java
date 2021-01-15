package Dao;

import Araclar.VTBaglanti;
import Nesneler.Alim;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlimDAO extends VTBaglanti {

    private UrunDAO urunDao;
    private UreticiDAO ureticiDao;

    public void ekle(Alim u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("insert into alim (uretici_id,urun_id,miktar,fiyat) values(" + u.getUretici_Id() + "," + u.getUrun_Id() + "," + u.getMiktar() + "," + u.getFiyat() + ")");
            st.executeUpdate("update urun set stok=stok+" + u.getMiktar() + " where id=" + u.getUrun_Id());
            st.executeUpdate("update uretici set alacak=alacak+" + (u.getMiktar() * u.getFiyat()) + " where id=" + u.getUretici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    

    public List<Alim> oku(int syf, int kayitSys) {
        List<Alim> liste = new ArrayList<>();
        int start=(syf-1)*kayitSys;
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select * from alim order by id limit "+start+" , "+kayitSys);

            while (rs.next()) {
                Alim tmp = new Alim();
                tmp.setId(rs.getInt("id"));
                tmp.setTarih(rs.getDate("tarih"));
                tmp.setMiktar(rs.getInt("miktar"));
                tmp.setFiyat(rs.getInt("fiyat"));
                tmp.setUretici_Id(rs.getInt("uretici_id"));
                tmp.setUrun_Id(rs.getInt("urun_id"));

                liste.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return liste;
    }
    public List<Alim> rapor(int syf, int kayitSys) {
        List<Alim> liste = new ArrayList<>();
        int start=(syf-1)*kayitSys;
        try {
            Statement st = this.baglan().createStatement();
            
            ResultSet rs = st.executeQuery("select urun_id,sum(miktar) as miktar from alim group by urun_id order by miktar desc limit "+start+" , "+kayitSys);
            while (rs.next()) {
                Alim tmp = new Alim();               
                tmp.setMiktar(rs.getInt("miktar"));                             
                tmp.setUrun_Id(rs.getInt("urun_id"));

                liste.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return liste;
    }
    
    public int say(){
        int sayi=0;
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs= st.executeQuery("select count(id) as alim_say from alim");
            rs.next();
            sayi=rs.getInt("alim_say");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sayi;
            }
    
    public void guncelle(Alim u) {
        

        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update alim set uretici_id=" + u.getUretici_Id() + ", urun_id=" + u.getUrun_Id() + ", miktar=" + u.getMiktar() + ", fiyat=" + u.getFiyat() + " where id=" + u.getId());
            st.executeUpdate("update urun set stok=stok+" + u.getMiktar() + " where id=" + u.getUrun_Id());
            st.executeUpdate("update uretici set alacak=alacak+" + (u.getMiktar() * u.getFiyat()) + " where id=" + u.getUretici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void sil(Alim u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("delete from alim where id=" + u.getId());
            st.executeUpdate("update urun set stok=stok-" + u.getMiktar() + " where id=" + u.getUrun_Id());
            st.executeUpdate("update uretici set alacak=alacak-" + (u.getMiktar() * u.getFiyat()) + " where id=" + u.getUretici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onceSil(Alim u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update urun set stok=stok-" + u.getMiktar() + " where id=" + u.getUrun_Id());
            st.executeUpdate("update uretici set alacak=alacak-" + (u.getMiktar() * u.getFiyat()) + " where id=" + u.getUretici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public UrunDAO getUrunDao() {
        if (urunDao == null) {
            this.urunDao = new UrunDAO();
        }
        return urunDao;
    }

    public UreticiDAO getUreticiDao() {
        if (ureticiDao == null) {
            this.ureticiDao = new UreticiDAO();
        }
        return ureticiDao;
    }

}
