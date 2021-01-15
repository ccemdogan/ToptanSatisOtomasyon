package Dao;

import Araclar.VTBaglanti;
import Nesneler.Satim;
import Nesneler.Urun;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SatimDAO extends VTBaglanti {

    private UrunDAO urunDao;
    private SaticiDAO saticiDao;

    public void ekle(Satim u) {
        Urun q = null;
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select * from urun where id=" + u.getUrun_Id());
            rs.next();
            q = new Urun();
            q.setId(rs.getInt("id"));
            q.setAd(rs.getString("ad"));
            q.setTur(rs.getString("tur"));
            q.setStok(rs.getInt("stok"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (q.getStok() > u.getMiktar()) {
            try {
                Statement st = this.baglan().createStatement();
                st.executeUpdate("insert into satim (satici_id,urun_id,miktar,fiyat) values(" + u.getSatici_Id() + "," + u.getUrun_Id() + "," + u.getMiktar() + "," + u.getFiyat() + ")");
                st.executeUpdate("update urun set stok=stok-" + u.getMiktar() + " where id=" + u.getUrun_Id());
                st.executeUpdate("update satici set borc=borc+" + (u.getMiktar() * u.getFiyat()) + " where id=" + u.getSatici_Id());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Stoktaki Ürün Yetersiz");
        }
    }

    public List<Satim> oku(int syf, int kayitSys) {
        List<Satim> liste = new ArrayList<>();
        int start=(syf-1)*kayitSys;
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select * from satim order by id limit "+start+" , "+kayitSys);

            while (rs.next()) {
                Satim tmp = new Satim();
                tmp.setId(rs.getInt("id"));
                tmp.setTarih(rs.getDate("tarih"));
                tmp.setMiktar(rs.getInt("miktar"));
                tmp.setFiyat(rs.getInt("fiyat"));
                tmp.setSatici_Id(rs.getInt("satici_id"));
                tmp.setUrun_Id(rs.getInt("urun_id"));

                liste.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return liste;
    }
    
        public List<Satim> rapor(int syf, int kayitSys) {
        List<Satim> liste = new ArrayList<>();
        int start=(syf-1)*kayitSys;
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs = st.executeQuery("select urun_id,sum(miktar) as miktar from satim group by urun_id order by miktar desc limit "+start+" , "+kayitSys);

            while (rs.next()) {
                Satim tmp = new Satim();
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
            ResultSet rs= st.executeQuery("select count(id) as satim_say from satim");
            rs.next();
            sayi=rs.getInt("satim_say");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sayi;
            }

    public void guncelle(Satim u) {

        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update satim set satici_id=" + u.getSatici_Id() + ", urun_id=" + u.getUrun_Id() + ", miktar=" + u.getMiktar() + ", fiyat=" + u.getFiyat() + " where id=" + u.getId());
            st.executeUpdate("update urun set stok=stok-" + u.getMiktar() + " where id=" + u.getUrun_Id());
            st.executeUpdate("update satici set borc=borc+" + (u.getMiktar() * u.getFiyat()) + " where id=" + u.getSatici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Satim u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("delete from satim where id=" + u.getId());
            st.executeUpdate("update urun set stok=stok+" + u.getMiktar() + " where id=" + u.getUrun_Id());
            st.executeUpdate("update satici set borc=borc-" + (u.getMiktar() * u.getFiyat()) + " where id=" + u.getSatici_Id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onceSil(Satim u) {
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update urun set stok=stok+" + u.getMiktar() + " where id=" + u.getUrun_Id());
            st.executeUpdate("update satici set borc=borc-" + (u.getMiktar() * u.getFiyat()) + " where id=" + u.getSatici_Id());
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

    public SaticiDAO getSaticiDao() {
        if (saticiDao == null) {
            this.saticiDao = new SaticiDAO();
        }
        return saticiDao;
    }

}
