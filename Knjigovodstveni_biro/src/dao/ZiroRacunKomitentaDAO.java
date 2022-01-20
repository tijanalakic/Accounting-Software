/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.ZiroRacunKomitentaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Tijana Lakic
 */
public class ZiroRacunKomitentaDAO {
      public static String getZiroRacunKomitentaByJIB(String JIB) {

        String brojRacuna=null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select brojRacuna from ziro_racun_komitenta where jib="+JIB);
            rs = ps.executeQuery();

            while (rs.next()) {
                brojRacuna = rs.getString(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZiroRacunKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ZiroRacunKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ZiroRacunKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return brojRacuna;
    }
       public boolean setZiroRacunKomitent(String brojRacuna, String jib)
    {

        Connection con = null;
        PreparedStatement myStatement = null;
        try {
            con = ConnectionPool.getInstance().checkOut();
            myStatement = con.prepareStatement("insert into ziro_racun_komitent values(default,?,?)");
            myStatement.setString(1,brojRacuna);
            myStatement.setString(2, jib);
         
            myStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ZiroRacunKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ZiroRacunKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (myStatement != null) {
                try {
                    myStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ZiroRacunKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }
}
