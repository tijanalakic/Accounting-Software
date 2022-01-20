/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import java.sql.Connection;
import dto.KomitentDTO;
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
public class KomitentDAO {

    public static ObservableList<KomitentDTO> getKomitente() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<KomitentDTO> komitenti = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from komitent");
            rs = ps.executeQuery();

            while (rs.next()) {
                String jib = rs.getString(1);
                String naziv=rs.getString(2);
                boolean pdvSistem=rs.getBoolean(3);
                String adresa=rs.getString(4);
                String postanskiBroj=rs.getString(5);
                

                komitenti.add(new KomitentDTO(jib, naziv, pdvSistem, adresa, postanskiBroj));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(komitenti);
    }
      public static KomitentDTO getKomitentByJIB(String jibKomitenta) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        KomitentDTO komitent = null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from komitent where jib="+jibKomitenta);
            rs = ps.executeQuery();

            while (rs.next()) {
                String jib = rs.getString(1);
                String naziv=rs.getString(2);
                boolean pdvSistem=rs.getBoolean(3);
                String adresa=rs.getString(4);
                String postanskiBroj=rs.getString(5);
                

               komitent= new KomitentDTO(jib, naziv, pdvSistem, adresa, postanskiBroj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return komitent;
    }
    public boolean setKomitent(String jib, String naziv, boolean pdvSistem, String adresa,  String postanskiBroj)
    {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("insert into komitent values(default,?,?,?,?,?,?)");
            ps.setString(1,jib);
            ps.setString(2, naziv);
            ps.setBoolean(3, pdvSistem);
            ps.setString(4, adresa);
            ps.setString(5, postanskiBroj);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }
      public boolean updateKomitent(String jib,String naziv,boolean pdvSistem,String adresa) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("update komitent "
                    + "SET naziv=? pdvsistem=? adresa=? WHERE jib=" + jib);
            ps.setString(1, naziv);
            ps.setBoolean(2, pdvSistem);
            ps.setString(3, adresa);

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KomitentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }

    
}

