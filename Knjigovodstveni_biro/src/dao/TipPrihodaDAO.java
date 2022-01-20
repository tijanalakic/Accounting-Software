/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.TipPrihodaDTO;
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
public class TipPrihodaDAO {
     public static ObservableList<TipPrihodaDTO> getTipoviPrihoda() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<TipPrihodaDTO> tipoviPrihoda = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from tip_prihoda");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String naziv=rs.getString(2);
                

                tipoviPrihoda.add(new TipPrihodaDTO(id, naziv));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipPrihodaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipPrihodaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipPrihodaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(tipoviPrihoda);
    } 
      public static TipPrihodaDTO getTipPrihodaById(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        TipPrihodaDTO tipPrihoda = null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from tip_prihoda where id="+id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idTP = rs.getInt(1);
                String naziv=rs.getString(2);
                

                tipPrihoda=new TipPrihodaDTO(idTP, naziv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipPrihodaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipPrihodaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipPrihodaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return tipPrihoda;
    } 
}
