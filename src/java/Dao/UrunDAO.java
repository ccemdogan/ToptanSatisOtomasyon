/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Araclar.VTBaglanti;
import Nesneler.Urun;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cem
 */
public class UrunDAO extends VTBaglanti {
    
        
    public void ekle(Urun u){
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("insert into urun (ad,tur) values('"+u.getAd()+"','"+u.getTur()+"')");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     public String bul(int id){
        Urun q=null;
        String urunad;
        try {
            Statement st=this.baglan().createStatement();
            ResultSet rs=st.executeQuery("select * from urun where id="+id);
            rs.next();
            q=new Urun();
            q.setId(rs.getInt("id"));
            q.setAd(rs.getString("ad"));
            q.setTur(rs.getString("tur"));
            q.setStok(rs.getInt("stok"));
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }        
        urunad=q.getAd();
        return urunad;        
    }
    
    public List<Urun> oku(int syf, int kayitSys){
        List<Urun> liste=new ArrayList<>();
        int start=(syf-1)*kayitSys;         
        try {
           
            Statement st = this.baglan().createStatement();
            ResultSet rs= st.executeQuery("select * from urun order by id limit "+start+" , "+kayitSys);
            
            while (rs.next()){
                Urun tmp= new Urun(rs.getInt("id"), rs.getString("ad"), rs.getString("tur"), rs.getInt("stok"));
                liste.add(tmp);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return liste;
        
    }
    
     public List<Urun> oku1(){
        List<Urun> liste=new ArrayList<>();
        
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs= st.executeQuery("select * from urun order by id");
            
            while (rs.next()){
                Urun tmp= new Urun(rs.getInt("id"), rs.getString("ad"), rs.getString("tur"), rs.getInt("stok"));
                liste.add(tmp);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return liste;
            }
    
      public int say(){
        int sayi=0;
        try {
            Statement st = this.baglan().createStatement();
            ResultSet rs= st.executeQuery("select count(id) as urun_say from urun");
            rs.next();
            sayi=rs.getInt("urun_say");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sayi;
            }
    
    public void guncelle(Urun u){
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("update urun set ad='"+u.getAd()+"', tur='"+u.getTur()+"' where id="+u.getId());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void sil(Urun u){
        try {
            Statement st = this.baglan().createStatement();
            st.executeUpdate("delete from urun where id="+u.getId());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
