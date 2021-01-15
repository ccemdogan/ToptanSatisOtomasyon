package Kontrol;

/**
 *
 * @author cem
 */
import Dao.UrunDAO;
import Nesneler.Urun;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.List;
import javax.faces.bean.*;


@ManagedBean
@SessionScoped
public class UrunKontrol implements Serializable {

    private UrunDAO dao;
    private Urun nesne;

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
        this.nesne = new Urun();
        return "/Urun/liste";
    }

    public List<Urun> getOku() {
        return this.getDao().oku(sayfa, kayitSayisi);
    }
    public List<Urun> getrapor(){  
    return this.getDao().rapor(sayfa, kayitSayisi);
    }
    
  
    
    public String guncelleForm(Urun u) {
        this.nesne = u;
        return "/Urun/guncelle";
    }

    public String guncelle() {
        this.getDao().guncelle(nesne);
        this.nesne = new Urun();
        return "/Urun/liste";
    }

    public void sil(Urun u) {
        this.getDao().sil(u);
    }

    public UrunKontrol() {
    }

    public UrunDAO getDao() {
        if (this.dao == null) {
            this.dao = new UrunDAO();
        }
        return dao;
    }

    public void setDao(UrunDAO dao) {
        this.dao = dao;
    }

    public Urun getNesne() {
        if (this.nesne == null) {
            this.nesne = new Urun();
        }
        return nesne;
    }

    public void setNesne(Urun nesne) {
        this.nesne = nesne;
    }

}