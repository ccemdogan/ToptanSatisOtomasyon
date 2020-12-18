package Kontrol;

import Dao.UreticiDAO;
import Nesneler.Alim;
import Nesneler.Kasacikis;

import Nesneler.Uretici;
import java.io.*;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped
public class UreticiKontrol implements Serializable {

    private UreticiDAO dao;
    private Uretici nesne;

    public String ekle() {
        this.getDao().ekle(nesne);
        this.nesne=new Uretici();
        return "/Uretici/liste";
    }

    public List<Uretici> getOku() {
        return this.getDao().oku();
    }
    
    public String alisOku(Uretici u) {
        this.nesne = u;
        return "/Uretici/alislar";
    }

public List<Alim> getAlisListe() {
        return this.getDao().alisOku(nesne);
    }

    public String kasaCikisOku(Uretici u) {
        this.nesne = u;
        return "/Uretici/cari";
    }

    public List<Kasacikis> getKasacikisListe() {
        return this.getDao().kasaCikisOku(nesne);
    }

    public String guncelleForm(Uretici u) {
        this.nesne = u;
        return "/Uretici/guncelle";
    }

    public String guncelle() {
        this.getDao().guncelle(nesne);
        this.nesne=new Uretici();
        return "/Uretici/liste";
    }

    public void sil(Uretici u) {
        this.getDao().sil(u);
    }

    public UreticiKontrol() {
    }

    public UreticiDAO getDao() {
        if (this.dao == null) {
            this.dao = new UreticiDAO();
        }
        return dao;
    }

    public void setDao(UreticiDAO dao) {
        this.dao = dao;
    }

    public Uretici getNesne() {
        if (this.nesne == null) {
            this.nesne = new Uretici();
        }
        return nesne;
    }

    public void setNesne(Uretici nesne) {
        this.nesne = nesne;
    }

}
