package Araclar;

/**
 *
 * @author cem
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public abstract class VTBaglanti {

    private Connection baglanti;

    public Connection baglan() throws SQLException {
        if (this.baglanti==null || this.baglanti.isClosed()){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarkuteri?user=cem&password=cem");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        return this.baglanti;

    }
}
