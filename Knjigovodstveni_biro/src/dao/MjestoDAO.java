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
public class MjestoDAO {
         public static ObservableList<MjestoDTO> getMjesta() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<MjestoDTO> mjesta = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from mjesto");
            rs = ps.executeQuery();

            while (rs.next()) {
                String postanskiBroj = rs.getString(1);
                String naziv=rs.getString(2);
                

                mjesta.add(new MjestoDTO(postanskiBroj, naziv));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MjestoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MjestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MjestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(mjesta);
    }
         public static String getNazivMjestaByPostanskiBroj(String postanskiBroj) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String nazivMjesta =null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from mjesto where postanskiBroj="+postanskiBroj);
            rs = ps.executeQuery();

            while (rs.next()) {
                String naziv=rs.getString(2);
                            }
        } catch (SQLException ex) {
            Logger.getLogger(MjestoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MjestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MjestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return nazivMjesta;
    }
         
}
