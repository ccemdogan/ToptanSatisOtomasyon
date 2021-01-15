package Kontrol;


import Dao.AlimDAO;
import Dao.UreticiDAO;
import Dao.UrunDAO;
import Nesneler.Alim;
import Nesneler.Uretici;
import Nesneler.Urun;
import java.io.*;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped
public class AlimKontrol implements Serializable {

    private AlimDAO dao;
    private Alim nesne;
   
    private UrunDAO urunDao;
    private UreticiDAO ureticiDao;
    private List<Urun> urunListe;
    private List<Uretici> ureticiListe;
    
    private int sayfa = 1;
    private int kayitSayisi = 8;
    private int sayfaSayisi;

    public void sonraki() {
        if (this.sayfa == this.getSayfaSayisi()) {
            this.sayfa = 1;
        } else {
            this.sayfa++;
        }
    }

    public void onceki() {
        if (this.sayfa == 1) {
            this.sayfa = this.getSayfaSayisi();
        } else {
            this.sayfa--;
        }
    }

    public int getSayfa() {
        return sayfa;
    }

    public void setSayfa(int sayfa) {
        this.sayfa = sayfa;
    }

    public int getKayitSayisi() {
        return kayitSayisi;
    }

    public void setKayitSayisi(int kayitSayisi) {
        this.kayitSayisi = kayitSayisi;
    }

    public int getSayfaSayisi() {
        this.sayfaSayisi = (int) Math.ceil(this.getDao().say() / (double) kayitSayisi);
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }
    
    public String ekle() {
        this.getDao().ekle(nesne);
        this.nesne = new Alim();
        return "/Alim/liste";
    }

    public List<Alim> getOku() {
        return this.getDao().oku(this.sayfa,this.kayitSayisi);
    }
        public List<Alim> getRapor() {
        return this.getDao().rapor(this.sayfa,this.kayitSayisi);
    }

    public String guncelleForm(Alim u) {
        this.nesne = u;
        
        return "/Alim/guncelle";
    }
  
    public String guncelle() {        
        this.getDao().guncelle(nesne);
        this.nesne = new Alim();
        return "/Alim/liste";
    }

    public void sil(Alim u) {
        this.getDao().sil(u);
    }
    
    public void onceSil(Alim u) {
        this.getDao().onceSil(u);
    }

    public AlimKontrol() {
    }

    public AlimDAO getDao() {
        if (this.dao == null) {
            this.dao = new AlimDAO();
        }
        return dao;
    }

    public void setDao(AlimDAO dao) {
        this.dao = dao;
    }

    public Alim getNesne() {
        if (this.nesne == null) {
            this.nesne = new Alim();
        }
        return nesne;
    }

    public void setNesne(Alim nesne) {
        this.nesne = nesne;
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

    public List<Urun> getUrunListe() {
        this.urunListe = this.getUrunDao().oku1();
        return urunListe;
    }

    public void setUrunListe(List<Urun> urunListe) {
        this.urunListe = urunListe;
    }

    public List<Uretici> getUreticiListe() {
        this.ureticiListe = this.getUreticiDao().oku();
        return ureticiListe;
    }

    public void setUreticiListe(List<Uretici> ureticiListe) {
        this.ureticiListe = ureticiListe;
    }

  
    

}
