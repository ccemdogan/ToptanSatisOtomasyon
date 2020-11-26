package Kontrol;

import Dao.SaticiDAO;
import Nesneler.Satici;
import java.io.*;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped
public class SaticiKontrol implements Serializable {

    private SaticiDAO dao;
    private Satici nesne;

    public String ekle() {
        this.getDao().ekle(nesne);
        this.nesne = new Satici();
        return "/Satici/liste";
    }

    public List<Satici> getOku() {
        return this.getDao().oku();
    }

    public String satisOku(Satici u) {
        this.nesne = u;
        return "/Satici/satislar";
    }

    public String guncelleForm(Satici u) {
        this.nesne = u;
        return "/Satici/guncelle";
    }

    public String guncelle() {
        this.getDao().guncelle(nesne);
        this.nesne = new Satici();
        return "/Satici/liste";
    }

    public void sil(Satici u) {
        this.getDao().sil(u);
    }

    public SaticiKontrol() {
    }

    public SaticiDAO getDao() {
        if (this.dao == null) {
            this.dao = new SaticiDAO();
        }
        return dao;
    }

    public void setDao(SaticiDAO dao) {
        this.dao = dao;
    }

    public Satici getNesne() {
        if (this.nesne == null) {
            this.nesne = new Satici();
        }
        return nesne;
    }

    public void setNesne(Satici nesne) {
        this.nesne = nesne;
    }

}