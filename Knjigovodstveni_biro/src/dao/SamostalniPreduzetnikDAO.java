/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.SamostalniPreduzetnikDTO;
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
public class SamostalniPreduzetnikDAO {
   public static ObservableList<SamostalniPreduzetnikDTO> getSamostalnePreduzetnike() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<SamostalniPreduzetnikDTO> samostalniPreduzetnici = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from samostalni_preduzetnik ");
            rs = ps.executeQuery();

            while (rs.next()) {
                String jib = rs.getString(1);
                String naziv=rs.getString(2);
                String sjedisteFirme=rs.getString(3);
                String sifraDjelatnosti=rs.getString(4);
                String nazivDjelatnosti=rs.getString(5);
                String jmb=rs.getString(6);
                String ime=rs.getString(7);
                String prezime=rs.getString(8);
                String adresa=rs.getString(9);
                String postanskiBroj=rs.getString(10);

                samostalniPreduzetnici.add(new SamostalniPreduzetnikDTO(jib, naziv, sjedisteFirme, sifraDjelatnosti, 
                     nazivDjelatnosti, jmb, ime, prezime, adresa, postanskiBroj));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SamostalniPreduzetnikDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SamostalniPreduzetnikDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SamostalniPreduzetnikDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(samostalniPreduzetnici);
    } 
}
