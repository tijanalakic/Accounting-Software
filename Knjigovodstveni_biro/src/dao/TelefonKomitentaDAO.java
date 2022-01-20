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
public class TelefonKomitentaDAO {
     public static String getTelefonSPByJIB(String JIB) {

        String brojTelefona=null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select brojTelefona from broj_telefona_komitenta where jib="+JIB);
            rs = ps.executeQuery();

            while (rs.next()) {
                brojTelefona = rs.getString(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelefonKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TelefonKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TelefonKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return brojTelefona;
    }
      public boolean setTelefonKomitent(String brojTelefona, String jib)
    {

        Connection con = null;
        PreparedStatement myStatement = null;
        try {
            con = ConnectionPool.getInstance().checkOut();
            myStatement = con.prepareStatement("insert into telefon_komitent values(default,?,?)");
            myStatement.setString(1,brojTelefona);
            myStatement.setString(2, jib);
         
            myStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TelefonKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TelefonKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (myStatement != null) {
                try {
                    myStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TelefonKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }
}
