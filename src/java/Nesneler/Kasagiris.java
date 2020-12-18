package Nesneler;

import java.util.Date;

public class Kasagiris {

    private int Id;
    private int Satici_Id;
    private int Tahsilat;
    private Date Tarih;
    private String Tahsilat_Sekli;

    public Kasagiris() {
    }

    public Kasagiris(int Id, int Satici_Id, int Tahsilat, Date Tarih, String Tahsilat_Sekli) {
        this.Id = Id;
        this.Satici_Id = Satici_Id;
        this.Tahsilat = Tahsilat;
        this.Tarih = Tarih;
        this.Tahsilat_Sekli = Tahsilat_Sekli;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getSatici_Id() {
        return Satici_Id;
    }

    public void setSatici_Id(int Satici_Id) {
        this.Satici_Id = Satici_Id;
    }

    public int getTahsilat() {
        return Tahsilat;
    }

    public void setTahsilat(int Tahsilat) {
        this.Tahsilat = Tahsilat;
    }

    public Date getTarih() {
        return Tarih;
    }

    public void setTarih(Date Tarih) {
        this.Tarih = Tarih;
    }

    public String getTahsilat_Sekli() {
        return Tahsilat_Sekli;
    }

    public void setTahsilat_Sekli(String Tahsilat_Sekli) {
        this.Tahsilat_Sekli = Tahsilat_Sekli;
    }

}
