/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.UlaznaFakturaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Tijana Lakic
 */
public class UlaznaFakturaDAO {
     public boolean setUlaznaFaktura( String samostalniPreduzetnikJIB,String nazivFakture,
            Date datum,String komitentJIB,double iznosBezPDV, double ukupnoSaPDV,
            double iznosPausalNaknade,double ukupanUlazniPorez, double ulazniPorezOdbitni,
            double ulazniPorezNeodbitni,  int idTipaTroska, boolean uvoz,boolean gotovina)
    {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("insert into ulazna_faktura values(default,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,samostalniPreduzetnikJIB);
            ps.setString(2, nazivFakture);
            ps.setDate(3, datum);
            ps.setString(4, komitentJIB);
            ps.setDouble(5, iznosBezPDV);
            ps.setDouble(6, ukupnoSaPDV);
            ps.setDouble(7, iznosPausalNaknade);
            ps.setDouble(8, ukupanUlazniPorez);
            ps.setDouble(9, ulazniPorezOdbitni);
            ps.setDouble(10, ulazniPorezNeodbitni);
            ps.setInt(11,idTipaTroska);
            ps.setBoolean(12, uvoz);
            ps.setBoolean(13, gotovina);


            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }
     public static ObservableList<UlaznaFakturaDTO> getUlazneFaktureBySPAndKomitent(String jib,String komitentJIB) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<UlaznaFakturaDTO> ulazneByKomitent = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from ulazna_faktura where samostalniPreduzetnikJIB="+jib+" and "
                    + "komitentJIB="+komitentJIB);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idFakture=rs.getInt(1);
                String samostalniPreduzetnikJIB = rs.getString(2);
                String nazivFakture=rs.getString(3);
                Date datum=rs.getDate(4);
                String komitentJib=rs.getString(5);
                double iznosBezPDV=rs.getDouble(6);
                double ukupnoSaPDV=rs.getDouble(7);
                double iznosPausalneNaknade=rs.getDouble(8);
                double ukupniUlazniPorez=rs.getDouble(9);
                double ukupniPorezOdbitni=rs.getDouble(10);
                double ukupniPorezNeodbitni=rs.getDouble(11);
                int idTipaTroska=rs.getInt(12);
                boolean uvoz=rs.getBoolean(13);
                boolean gotovina=rs.getBoolean(14);



                ulazneByKomitent.add(new UlaznaFakturaDTO( idFakture,samostalniPreduzetnikJIB,nazivFakture,
                        datum, komitentJib, iznosBezPDV,
                        ukupnoSaPDV, iznosPausalneNaknade, ukupniUlazniPorez, ukupniPorezOdbitni,
                        ukupniPorezNeodbitni, idTipaTroska,
                        uvoz, gotovina));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(ulazneByKomitent);
    }
     public static UlaznaFakturaDTO getUlaznaFakturaById(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        UlaznaFakturaDTO ulazna =null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from ulazna_faktura where id="+id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idFakture=rs.getInt(1);
                String samostalniPreduzetnikJIB = rs.getString(2);
                String nazivFakture=rs.getString(3);
                Date datum=rs.getDate(4);
                String komitentJib=rs.getString(5);
                double iznosBezPDV=rs.getDouble(6);
                double ukupnoSaPDV=rs.getDouble(7);
                double iznosPausalneNaknade=rs.getDouble(8);
                double ukupniUlazniPorez=rs.getDouble(9);
                double ukupniPorezOdbitni=rs.getDouble(10);
                double ukupniPorezNeodbitni=rs.getDouble(11);
                int idTipaTroska=rs.getInt(12);
                boolean uvoz=rs.getBoolean(13);
                boolean gotovina=rs.getBoolean(14);



                ulazna=new UlaznaFakturaDTO( idFakture,samostalniPreduzetnikJIB,nazivFakture,
                        datum, komitentJib, iznosBezPDV,
                        ukupnoSaPDV, iznosPausalneNaknade, ukupniUlazniPorez, ukupniPorezOdbitni,
                        ukupniPorezNeodbitni, idTipaTroska,
                        uvoz, gotovina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return ulazna;
    }
}
