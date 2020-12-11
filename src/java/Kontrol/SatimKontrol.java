package Kontrol;


import Dao.SatimDAO;
import Dao.SaticiDAO;
import Dao.UrunDAO;
import Nesneler.Satim;
import Nesneler.Satici;
import Nesneler.Urun;
import java.io.*;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped
public class SatimKontrol implements Serializable {

    private SatimDAO dao;
    private Satim nesne;   
    private UrunDAO urunDao;
    private SaticiDAO saticiDao;
    private List<Urun> urunListe;
    private List<Satici> saticiListe;
    
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
        this.nesne = new Satim();
        return "/Satim/liste";
    }

    public List<Satim> getOku() {
        return this.getDao().oku(this.sayfa, this.kayitSayisi);
    }

    public String guncelleForm(Satim u) {
        this.nesne = u;
        
        return "/Satim/guncelle";
    }
  
    public String guncelle() {        
        this.getDao().guncelle(nesne);
        this.nesne = new Satim();
        return "/Satim/liste";
    }

    public void sil(Satim u) {
        this.getDao().sil(u);
    }
    
    public void onceSil(Satim u) {
        this.getDao().onceSil(u);
    }

    public SatimKontrol() {
    }

    public SatimDAO getDao() {
        if (this.dao == null) {
            this.dao = new SatimDAO();
        }
        return dao;
    }

    public void setDao(SatimDAO dao) {
        this.dao = dao;
    }

    public Satim getNesne() {
        if (this.nesne == null) {
            this.nesne = new Satim();
        }
        return nesne;
    }

    public void setNesne(Satim nesne) {
        this.nesne = nesne;
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

    public List<Urun> getUrunListe() {
        this.urunListe = this.getUrunDao().oku1();
        return urunListe;
    }

    public void setUrunListe(List<Urun> urunListe) {
        this.urunListe = urunListe;
    }

    public List<Satici> getSaticiListe() {
        this.saticiListe = this.getSaticiDao().oku();
        return saticiListe;
    }

    public void setSaticiListe(List<Satici> saticiListe) {
        this.saticiListe = saticiListe;
    }

  
    

    
}
