package Kontrol;

import Dao.MerkezDAO;
import Nesneler.Merkez;
import java.io.*;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped

public class MerkezKontrol implements Serializable {

    private MerkezDAO dao;
    private Merkez nesne;

    public List<Merkez> getOku() {
        return this.getDao().oku();
    }

    public MerkezKontrol() {
    }

    public MerkezDAO getDao() {
        if (this.dao == null) {
            this.dao = new MerkezDAO();
        }
        return dao;
    }

    public void setDao(MerkezDAO dao) {
        this.dao = dao;
    }

    public Merkez getNesne() {
        if (this.nesne == null) {
            this.nesne = new Merkez();
        }
        return nesne;
    }

    public void setNesne(Merkez nesne) {
        this.nesne = nesne;
    }

}
