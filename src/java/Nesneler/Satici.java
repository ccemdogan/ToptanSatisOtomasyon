package Nesneler;

public class Satici {

    private int Id;
    private String Ad;
    private String Adres;
    private String Tlf;
    private int Borc;

    public Satici() {
    }

    public Satici(int Id, String Ad, String Adres, String Tlf, int Borc) {
        this.Id = Id;
        this.Ad = Ad;
        this.Adres = Adres;
        this.Tlf = Tlf;
        this.Borc = Borc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }

    public String getTlf() {
        return Tlf;
    }

    public void setTlf(String Tlf) {
        this.Tlf = Tlf;
    }

    public int getBorc() {
        return Borc;
    }

    public void setBorc(int Borc) {
        this.Borc = Borc;
    }

}
