package Nesneler;

public class Merkez {

    private String Ad;
    private String Adres;
    private String Tlf;
    private int Kasa;

    public Merkez() {
    }

    public Merkez(String Ad, String Adres, String Tlf, int Kasa) {
        this.Ad = Ad;
        this.Adres = Adres;
        this.Tlf = Tlf;
        this.Kasa = Kasa;
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

    public int getKasa() {
        return Kasa;
    }

    public void setKasa(int Kasa) {
        this.Kasa = Kasa;
    }

}
