/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.IzlaznaFakturaDTO;
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
public class IzlaznaFakturaDAO {
     public static ObservableList<IzlaznaFakturaDTO> getIzlazneFaktureBySP(String jib) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<IzlaznaFakturaDTO> izlaznaFakturaDTOs = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from izlazna_faktura where samostalniPreduzetnikJIB="+jib);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idFakture=rs.getInt(1);
                String samostalniPreduzetnikJIB = rs.getString(2);
                String nazivFakture=rs.getString(3);
                Date datum=rs.getDate(4);
                String komitentJIB=rs.getString(5);
                double iznosFakture=rs.getDouble(6);
                double iznosVanposlovneSvrhe=rs.getDouble(7);
                double iznosIzvoza=rs.getDouble(8);
                double iznosOstalo=rs.getDouble(9);
                double osnovicaZaPDV=rs.getDouble(10);
                double ukupniPDV=rs.getDouble(11);
                int idTipaPrihoda=rs.getInt(12);


                izlaznaFakturaDTOs.add(new IzlaznaFakturaDTO(idFakture,samostalniPreduzetnikJIB,nazivFakture,
             datum,komitentJIB, iznosFakture,  iznosVanposlovneSvrhe,
             iznosIzvoza, iznosOstalo,  osnovicaZaPDV, ukupniPDV,   idTipaPrihoda));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(izlaznaFakturaDTOs);
    }
     public static IzlaznaFakturaDTO getIzlaznaFakturaById(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        IzlaznaFakturaDTO izlaznaFakturaDTO=null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from izlazna_faktura where id="+id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idFakture=rs.getInt(1);
                String samostalniPreduzetnikJIB = rs.getString(2);
                String nazivFakture=rs.getString(3);
                Date datum=rs.getDate(4);
                String komitentJIB=rs.getString(5);
                double iznosFakture=rs.getDouble(6);
                double iznosVanposlovneSvrhe=rs.getDouble(7);
                double iznosIzvoza=rs.getDouble(8);
                double iznosOstalo=rs.getDouble(9);
                double osnovicaZaPDV=rs.getDouble(10);
                double ukupniPDV=rs.getDouble(11);
                int idTipaPrihoda=rs.getInt(12);


                izlaznaFakturaDTO=new IzlaznaFakturaDTO(idFakture,samostalniPreduzetnikJIB,nazivFakture,
             datum,komitentJIB, iznosFakture,  iznosVanposlovneSvrhe,
             iznosIzvoza, iznosOstalo,  osnovicaZaPDV, ukupniPDV,   idTipaPrihoda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return izlaznaFakturaDTO;
    }
      public static ObservableList<IzlaznaFakturaDTO> getIzlazneFaktureBySPAndKomitent(String jib,String komitentJIB) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<IzlaznaFakturaDTO> izlazneByKomitent = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from izlazna_faktura where samostalniPreduzetnikJIB="+jib+" and "
                    + "komitentJIB="+komitentJIB);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idFakture=rs.getInt(1);
                String samostalniPreduzetnikJIB = rs.getString(2);
                String nazivFakture=rs.getString(3);
                Date datum=rs.getDate(4);
                String komitentJib=rs.getString(5);
                double iznosFakture=rs.getDouble(6);
                double iznosVanposlovneSvrhe=rs.getDouble(7);
                double iznosIzvoza=rs.getDouble(8);
                double iznosOstalo=rs.getDouble(9);
                double osnovicaZaPDV=rs.getDouble(10);
                double ukupniPDV=rs.getDouble(11);
                int idTipaPrihoda=rs.getInt(12);


                izlazneByKomitent.add(new IzlaznaFakturaDTO(idFakture,samostalniPreduzetnikJIB,nazivFakture,
             datum,komitentJIB, iznosFakture,  iznosVanposlovneSvrhe,
             iznosIzvoza, iznosOstalo,  osnovicaZaPDV, ukupniPDV,   idTipaPrihoda));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(izlazneByKomitent);
    }
     public boolean setIzlaznaFaktura(String samostalniPreduzetnikJIB,String nazivFakture,
            Date datum,String komitentJIB,double iznosFakture, double iznosVanposlovneSvrhe,
            double iznosIzvoza,double iznosOstalo, double osnovicaZaPDV,double ukupniPDV,  int idTipaPrihoda)
    {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("insert into izlazna_faktura values(default,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,samostalniPreduzetnikJIB);
            ps.setString(2, nazivFakture);
            ps.setDate(3, datum);
            ps.setString(4, komitentJIB);
            ps.setDouble(5, iznosFakture);
            ps.setDouble(6, iznosVanposlovneSvrhe);
            ps.setDouble(7, iznosIzvoza);
            ps.setDouble(8, iznosOstalo);
            ps.setDouble(9, osnovicaZaPDV);
            ps.setDouble(10, ukupniPDV);
            ps.setInt(11,idTipaPrihoda);

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IzlaznaFakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }
}
