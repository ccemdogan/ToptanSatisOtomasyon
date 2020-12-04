package Nesneler;

import java.util.Date;

public class Alim {

    private int Id;
    private Date Tarih;
    private int Miktar;
    private int Fiyat;
    private int Urun_Id;
    private int Uretici_Id;

    public int getUrun_Id() {
        return Urun_Id;
    }

    public void setUrun_Id(int Urun_Id) {
        this.Urun_Id = Urun_Id;
    }

    public int getUretici_Id() {
        return Uretici_Id;
    }

    public void setUretici_Id(int Uretici_Id) {
        this.Uretici_Id = Uretici_Id;
    }

    public Alim(int Id, Date Tarih, int Miktar, int Fiyat, int Urun_Id, int Uretici_Id) {
        this.Id = Id;
        this.Tarih = Tarih;
        this.Miktar = Miktar;
        this.Fiyat = Fiyat;
        this.Urun_Id = Urun_Id;
        this.Uretici_Id = Uretici_Id;
    }

    public Alim() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getTarih() {
        return Tarih;
    }

    public void setTarih(Date Tarih) {
        this.Tarih = Tarih;
    }

    public int getMiktar() {
        return Miktar;
    }

    public void setMiktar(int Miktar) {
        this.Miktar = Miktar;
    }

    public int getFiyat() {
        return Fiyat;
    }

    public void setFiyat(int Fiyat) {
        this.Fiyat = Fiyat;
    }

}
