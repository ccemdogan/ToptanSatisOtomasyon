package Nesneler;

public class Uretici {

    private int Id;
    private String Ad;
    private String Adres;
    private String Tlf;
    private int Alacak;

    public Uretici() {
    }

    public Uretici(int Id, String Ad, String Adres, String Tlf, int Alacak) {
        this.Id = Id;
        this.Ad = Ad;
        this.Adres = Adres;
        this.Tlf = Tlf;
        this.Alacak = Alacak;
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

    public int getAlacak() {
        return Alacak;
    }

    public void setAlacak(int Alacak) {
        this.Alacak = Alacak;
    }

}
