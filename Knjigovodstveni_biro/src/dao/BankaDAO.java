/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.BankaDTO;
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
public class BankaDAO {
     public static ObservableList<BankaDTO> getBanke() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<BankaDTO> banke = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from banka");
            rs = ps.executeQuery();

            while (rs.next()) {
                String sifra = rs.getString(1);
                String naziv=rs.getString(2);
                

                banke.add(new BankaDTO(sifra, naziv));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BankaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BankaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BankaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(banke);
    } 
     public static BankaDTO getBankaBySifra(String sifraBanke) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        BankaDTO banka = null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from banka where SifraBanke="+sifraBanke);
            rs = ps.executeQuery();

            while (rs.next()) {
                String sifra = rs.getString(1);
                String naziv=rs.getString(2);
                

                banka=new BankaDTO(sifra, naziv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BankaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BankaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BankaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return banka;
    } 
        
     public boolean setBanka(String sifraBanke,String nazivBanke) {

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("insert into banka values(?,?)");
            ps.setString(1, sifraBanke);
            ps.setString(2, nazivBanke);

           
        } catch (SQLException ex) {
            Logger.getLogger(BankaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BankaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            

        }
            return true;
    } 
}
