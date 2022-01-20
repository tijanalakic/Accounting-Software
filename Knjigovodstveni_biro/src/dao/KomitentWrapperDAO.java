/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.KomitentWrapperDTO;
import java.sql.CallableStatement;
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
public class KomitentWrapperDAO {

    public static ObservableList<KomitentWrapperDTO> getKomitentiWrappersBySP(String jib, String tip) {
        Connection con = null;
        PreparedStatement ps = null;

        ResultSet rs = null;
        ArrayList<KomitentWrapperDTO> komitenti = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select JIBKomitenta, "
                    + "Mjesto, "
                    + "BrojRacuna, "
                    + "Saldo "
                    + " from sp_komitent_view where JIBSamostalnogPreduzetnika=" + jib
                    + " and nazivTipaKomitenta='" + tip + "'");
            rs = ps.executeQuery();

            while (rs.next()) {

                komitenti.add(new KomitentWrapperDTO(KomitentDAO.getKomitentByJIB(rs.getString(1)),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomitentWrapperDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KomitentWrapperDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KomitentWrapperDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return FXCollections.observableArrayList(komitenti);
    }

    public KomitentWrapperDTO setKomitent(String spJib, String jib, String naziv, boolean pdvSistem, String adresa, String postanskiBroj,
            String telefon, String ziroRacun, int tipKomitenta, String sifraBanke) {

        KomitentWrapperDTO komitent = null;
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            con = ConnectionPool.getInstance().checkOut();
            cs = con.prepareCall("{ call dodaj_komitenta(?,?,?,?,?,?,?,?,?,?)}");
            
            cs.setString(1, spJib);
            cs.setInt(2, tipKomitenta);
            cs.setString(3, jib);
            cs.setString(4, naziv);
            cs.setBoolean(5, pdvSistem);
            cs.setString(6, adresa);
            cs.setString(7, postanskiBroj);
            cs.setString(8, telefon);
            cs.setString(9, sifraBanke);
            cs.setString(10, ziroRacun);

            cs.execute();
            System.out.println(cs);

            komitent = new KomitentWrapperDTO( spJib,  jib,  naziv,  pdvSistem,  adresa,  postanskiBroj,
             telefon,  ziroRacun,  tipKomitenta,  sifraBanke);

        } catch (SQLException ex) {
            Logger.getLogger(PDVPrijavaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (cs != null) {

                try {
                    cs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PDVPrijavaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return komitent;

    }
}
