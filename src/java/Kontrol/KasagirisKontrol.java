package Kontrol;

import Dao.SaticiDAO;
import Dao.KasagirisDAO;
import Nesneler.Satici;
import Nesneler.Kasagiris;
import java.io.*;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped

public class KasagirisKontrol implements Serializable {

    private KasagirisDAO dao;
    private Kasagiris nesne;
    private SaticiDAO saticiDao;
    private List<Satici> saticiListe;

    public String ekle() {
        this.getDao().ekle(nesne);
        this.nesne = new Kasagiris();
        return "/Kasagiris/liste";
    }

    public List<Kasagiris> getOku() {
        return this.getDao().oku();
    }

    public String guncelleForm(Kasagiris u) {
        this.nesne = u;

        return "/Kasagiris/guncelle";
    }

    public String guncelle() {
        this.getDao().guncelle(nesne);
        this.nesne = new Kasagiris();
        return "/Kasagiris/liste";
    }

    public void sil(Kasagiris u) {
        this.getDao().sil(u);
    }

    public void onceSil(Kasagiris u) {
        this.getDao().onceSil(u);
    }

    public KasagirisKontrol() {
    }

    public KasagirisDAO getDao() {
        if (this.dao == null) {
            this.dao = new KasagirisDAO();
        }
        return dao;
    }

    public void setDao(KasagirisDAO dao) {
        this.dao = dao;
    }

    public Kasagiris getNesne() {
        if (this.nesne == null) {
            this.nesne = new Kasagiris();
        }
        return nesne;
    }

    public void setNesne(Kasagiris nesne) {
        this.nesne = nesne;
    }

    public SaticiDAO getSaticiDao() {
        if (saticiDao == null) {
            this.saticiDao = new SaticiDAO();
        }
        return saticiDao;
    }

    public List<Satici> getSaticiListe() {
        this.saticiListe = this.getSaticiDao().oku();
        return saticiListe;
    }

    public void setSaticiListe(List<Satici> saticiListe) {
        this.saticiListe = saticiListe;
    }

}
