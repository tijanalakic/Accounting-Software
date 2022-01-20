/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tijana Lakic
 */
public class TelefonSamostalnogPreduzetnikaDAO {
     public static String getTelefonSPByJIB(String JIB) {

        String brojTelefona=null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select brojTelefona from broj_telefona_sp where jib="+JIB);
            rs = ps.executeQuery();

            while (rs.next()) {
                brojTelefona = rs.getString(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelefonSamostalnogPreduzetnikaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TelefonSamostalnogPreduzetnikaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TelefonSamostalnogPreduzetnikaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return brojTelefona;
    }
}