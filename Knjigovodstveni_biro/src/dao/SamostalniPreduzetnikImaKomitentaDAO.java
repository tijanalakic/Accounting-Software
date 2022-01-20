/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.MjestoDTO;
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
public class SamostalniPreduzetnikImaKomitentaDAO {
   public static ObservableList<String> getKomitenteByTipandSP(int tip,String jib) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<String> komitentiJIB = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select KomitentJIB from samostalni_preduzetnik_ima_komitent where"
                    + " idTipa="+tip+" and samostalniPreduzetnikJIB="+jib);
            rs = ps.executeQuery();

            while (rs.next()) {
                String komitentJIB = rs.getString(1);
                
                komitentiJIB.add(komitentJIB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SamostalniPreduzetnikImaKomitentaDAO
                    .class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SamostalniPreduzetnikImaKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SamostalniPreduzetnikImaKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(komitentiJIB);
    } 
}
