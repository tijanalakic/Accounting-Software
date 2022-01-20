/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.ZiroRacunDTO;
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
public class ZiroRacunDAO {
         public static ObservableList<ZiroRacunDTO> getZiroRacune() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<ZiroRacunDTO> ziroRacuni = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from ziro_racun");
            rs = ps.executeQuery();

            while (rs.next()) {
                String brojRacuna = rs.getString(1);
                String sifraBanke=rs.getString(2);
                

                ziroRacuni.add(new ZiroRacunDTO(brojRacuna, sifraBanke));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZiroRacunDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ZiroRacunDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ZiroRacunDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(ziroRacuni);
    }
            public boolean setZiroRacun(String brojRacuna, String sifraBanke)
    {

        Connection con = null;
        PreparedStatement myStatement = null;
        try {
            con = ConnectionPool.getInstance().checkOut();
            myStatement = con.prepareStatement("insert into ziro_racun values(default,?,?)");
            myStatement.setString(1,brojRacuna);
            myStatement.setString(2, sifraBanke);
         
            myStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ZiroRacunDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ZiroRacunDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (myStatement != null) {
                try {
                    myStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ZiroRacunDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }}
