/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.PDVprijavaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tijana Lakic
 */
public class PDVPrijavaDAO {

    public static PDVprijavaDTO prijava;

    public static PDVprijavaDTO executeStoredProcOUTParamsResulset(Date datumOd, Date datumDo, String spJIB) {

        Connection con = null;
        CallableStatement cs = null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            cs = con.prepareCall("{ call mjesecna_pdv_prijava(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
           
            cs.setDate(1, datumOd);
            cs.setDate(2, datumDo);
            cs.setString(3, spJIB);

            for (int i = 4; i < 17; i++) {
                
                cs.registerOutParameter(i, Types.DECIMAL);
            }

            cs.executeUpdate();

            prijava = new PDVprijavaDTO(cs.getDouble(4),
                                        cs.getDouble(5),
                                        cs.getDouble(6),
                                        cs.getDouble(7),
                                        cs.getDouble(8),
                                        cs.getDouble(9),
                                        cs.getDouble(10),
                                        cs.getDouble(11),
                                        cs.getDouble(12), 
                                        cs.getDouble(13),
                                        cs.getDouble(14),
                                        cs.getDouble(15),
                                        cs.getDouble(16));

        } catch (SQLException ex) {
            
            Logger.getLogger(PDVPrijavaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (con != null) {
                
                ConnectionPool.getInstance().checkIn(con);
            }
            if (cs != null) {

                try {
                    cs.close();
                } catch (SQLException ex) {
                    
                    Logger.getLogger(PDVPrijavaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return prijava;
    }
}
