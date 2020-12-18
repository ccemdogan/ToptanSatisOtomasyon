package Kontrol;

import Dao.KasacikisDAO;
import Dao.UreticiDAO;
import Nesneler.Kasacikis;
import Nesneler.Uretici;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped

public class KasacikisKontrol implements Serializable {

    private KasacikisDAO dao;
    private Kasacikis nesne;
    private UreticiDAO ureticiDao;
    private List<Uretici> ureticiListe;

    public String ekle() {
        this.getDao().ekle(nesne);
        this.nesne = new Kasacikis();
        return "/Kasacikis/liste";
    }

    public List<Kasacikis> getOku() {
        return this.getDao().oku();
    }

    public String guncelleForm(Kasacikis u) {
        this.nesne = u;

        return "/Kasacikis/guncelle";
    }

    public String guncelle() {
        this.getDao().guncelle(nesne);
        this.nesne = new Kasacikis();
        return "/Kasacikis/liste";
    }

    public void sil(Kasacikis u) {
        this.getDao().sil(u);
    }

    public void onceSil(Kasacikis u) {
        this.getDao().onceSil(u);
    }

    public KasacikisKontrol() {
    }

    public KasacikisDAO getDao() {
        if (this.dao == null) {
            this.dao = new KasacikisDAO();
        }
        return dao;
    }

    public void setDao(KasacikisDAO dao) {
        this.dao = dao;
    }

    public Kasacikis getNesne() {
        if (this.nesne == null) {
            this.nesne = new Kasacikis();
        }
        return nesne;
    }

    public void setNesne(Kasacikis nesne) {
        this.nesne = nesne;
    }

    public UreticiDAO getUreticiDao() {
        if (ureticiDao == null) {
            this.ureticiDao = new UreticiDAO();
        }
        return ureticiDao;
    }

    public List<Uretici> getUreticiListe() {
        this.ureticiListe = this.getUreticiDao().oku();
        return ureticiListe;
    }

    public void setUreticiListe(List<Uretici> ureticiListe) {
        this.ureticiListe = ureticiListe;
    }

    
}
