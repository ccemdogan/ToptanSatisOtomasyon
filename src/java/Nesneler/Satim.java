package Nesneler;

import java.util.Date;

public class Satim {
    private int Id;
    private Date Tarih;
    private int Miktar;
    private int Fiyat;
    private int Urun_Id;
    private int Satici_Id;

    public Satim() {
    }

    public Satim(int Id, Date Tarih, int Miktar, int Fiyat, int Urun_Id, int Satici_Id) {
        this.Id = Id;
        this.Tarih = Tarih;
        this.Miktar = Miktar;
        this.Fiyat = Fiyat;
        this.Urun_Id = Urun_Id;
        this.Satici_Id = Satici_Id;
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

    public int getUrun_Id() {
        return Urun_Id;
    }

    public void setUrun_Id(int Urun_Id) {
        this.Urun_Id = Urun_Id;
    }

    public int getSatici_Id() {
        return Satici_Id;
    }

    public void setSatici_Id(int Satici_Id) {
        this.Satici_Id = Satici_Id;
    }
    
    
    
}
