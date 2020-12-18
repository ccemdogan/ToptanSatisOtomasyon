package Nesneler;

import java.util.Date;

public class Kasacikis {

    private int Id;
    private int Uretici_Id;
    private int Odeme;
    private Date Tarih;
    private String Odeme_Sekli;

    public Kasacikis() {
    }

    public Kasacikis(int Id, int Uretici_Id, int Odeme, Date Tarih, String Odeme_Sekli) {
        this.Id = Id;
        this.Uretici_Id = Uretici_Id;
        this.Odeme = Odeme;
        this.Tarih = Tarih;
        this.Odeme_Sekli = Odeme_Sekli;
    }
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getUretici_Id() {
        return Uretici_Id;
    }

    public void setUretici_Id(int Uretici_Id) {
        this.Uretici_Id = Uretici_Id;
    }

    public int getOdeme() {
        return Odeme;
    }

    public void setOdeme(int Odeme) {
        this.Odeme = Odeme;
    }

    public Date getTarih() {
        return Tarih;
    }

    public void setTarih(Date Tarih) {
        this.Tarih = Tarih;
    }

    public String getOdeme_Sekli() {
        return Odeme_Sekli;
    }

    public void setOdeme_Sekli(String Odeme_Sekli) {
        this.Odeme_Sekli = Odeme_Sekli;
    }
    
    

}
