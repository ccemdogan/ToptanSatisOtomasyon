package Nesneler;

/**
 *
 * @author cem
 */

public class Urun {
    private int Id;
    private String Ad;
    private String Tur;
    private int Stok;

    public Urun() {
    }

    public Urun(int Id, String Ad, String Tur, int Stok) {
        this.Id = Id;
        this.Ad = Ad;
        this.Tur = Tur;
        this.Stok = Stok;
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

    public String getTur() {
        return Tur;
    }

    public void setTur(String Tur) {
        this.Tur = Tur;
    }

    public int getStok() {
        return Stok;
    }

    public void setStok(int Stok) {
        this.Stok = Stok;
    }
    
    
    
}
