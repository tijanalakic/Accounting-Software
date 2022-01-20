/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.TipTroskaDTO;
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
public class TipTroskaDAO {
    public static ObservableList<TipTroskaDTO> getTipoviTroska() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<TipTroskaDTO> tipoviTroska = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from tip_troska");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String naziv=rs.getString(2);
                

                tipoviTroska.add(new TipTroskaDTO(id, naziv));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipTroskaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipTroskaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipTroskaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(tipoviTroska);
    } 
      public static TipTroskaDTO getTipTroskaById(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        TipTroskaDTO tipTroska = null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from tip_troska where id="+id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idTT = rs.getInt(1);
                String naziv=rs.getString(2);
                

                tipTroska=new TipTroskaDTO(idTT, naziv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipTroskaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipTroskaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipTroskaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return tipTroska;
    } 
}
