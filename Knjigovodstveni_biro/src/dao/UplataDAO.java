/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.UplataDTO;
import java.sql.Connection;
import java.sql.Date;
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
public class UplataDAO {
 public static ObservableList<UplataDTO> getUplateBySP(String jib) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<UplataDTO> uplate = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from uplata where samostalniPreduzetnikJIB="+jib);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id=rs.getInt(1);
                String samostalniPreduzetnikJIB = rs.getString(2);
                String komitentJIB=rs.getString(3);
                Date datum=rs.getDate(4);
                int izlaznaFakturaId=rs.getInt(5);
                String brojDokumenta=rs.getString(6);
                double iznos=rs.getDouble(7);
                String opis=rs.getString(8);
                String sifraBanke=rs.getString(9);
                int idTipaPrihoda=rs.getInt(10);


                uplate.add(new UplataDTO(id,samostalniPreduzetnikJIB, komitentJIB, datum, izlaznaFakturaId,
                        brojDokumenta, iznos,opis,sifraBanke,idTipaPrihoda));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UplataDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(uplate);
    }
  public boolean updateUplata(int id, String samostalniPreduzetnikJIB, String komitentJIB,
            Date datum, int izlaznaFakturaId, String brojDokumenta, double iznos, String opis,
            String sifraBanke, int idTipaPrihoda) {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("update uplata set "
                    + "samostalniPreduzetnikJIB=?, "
                    + "komitentJIB=?, "
                    + "datum=?, "
                    + "izlaznaFakturaId=?, "
                    + "brojDokumenta=?, "
                    + "iznos=?, "
                    + "opis=?, "
                    + "sifrabanke=?, "
                    + "idtipaprihoda=? "
                    + "where id="+id);
           ps.setString(1, samostalniPreduzetnikJIB);
           ps.setString(2, komitentJIB);
           ps.setDate(3, datum);
           ps.setInt(4, izlaznaFakturaId);
           ps.setString(5, brojDokumenta);
           ps.setDouble(6, iznos);
           ps.setString(7, opis);
           ps.setString(8, sifraBanke);
           ps.setInt(9, idTipaPrihoda);
           //System.out.println(ps);
           ps.executeUpdate();
            

        } catch (SQLException ex) {
            Logger.getLogger(UplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            return true;    
  } 
   public boolean setUplata
        (String samostalniPreduzetnikJIB, String komitentJIB,
            Date datum, int izlaznaFakturaId, String brojDokumenta, double iznos, String opis,
            String sifraBanke, int idTipaPrihoda) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
           con = ConnectionPool.getInstance().checkOut();
           ps = con.prepareStatement("insert into uplata(samostalniPreduzetnikJIB, komitentJIB,  datum, izlaznaFakturaId,\n" +
"                        brojDokumenta, iznos,opis,sifraBanke,idTipaPrihoda) values(?,?,?,?,?,?,?,?,?)");
           ps.setString(1, samostalniPreduzetnikJIB);
           ps.setString(2, komitentJIB);
           ps.setDate(3, datum);
           ps.setInt(4, izlaznaFakturaId);
           ps.setString(5, brojDokumenta);
           ps.setDouble(6, iznos);
           ps.setString(7, opis);
           ps.setString(8, sifraBanke);
           ps.setInt(9, idTipaPrihoda);
           ps.execute();
            

        } catch (SQLException ex) {
            Logger.getLogger(UplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            return true;    
  } 
        public static boolean removeUplata(int id) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
           con = ConnectionPool.getInstance().checkOut();
           ps = con.prepareStatement("delete from uplata where id="+id);
           ps.execute();
            

        } catch (SQLException ex) {
            Logger.getLogger(UplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            return true;    
  } 
}
