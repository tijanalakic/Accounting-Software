/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.IsplataDTO;
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
public class IsplataDAO {
    public static ObservableList<IsplataDTO> getIsplateBySP(String jib) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<IsplataDTO> isplata = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from isplata where samostalniPreduzetnikJIB="+jib);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id=rs.getInt(1);
                String samostalniPreduzetnikJIB = rs.getString(2);
                String komitentJIB=rs.getString(3);
                Date datum=rs.getDate(4);
                int ulaznaFakturaId=rs.getInt(5);
                String brojDokumenta=rs.getString(6);
                double iznos=rs.getDouble(7);
                String opis=rs.getString(8);
                String sifraBanke=rs.getString(9);
                int idTipaTroska=rs.getInt(10);


                isplata.add(new IsplataDTO(id,samostalniPreduzetnikJIB, komitentJIB,  datum, ulaznaFakturaId,
                        brojDokumenta, iznos,opis,sifraBanke,idTipaTroska));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IsplataDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IsplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IsplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(isplata);
    }
  public boolean updateIsplata(int id, String samostalniPreduzetnikJIB, String komitentJIB,
            Date datum, int ulaznaFakturaId, String brojDokumenta, double iznos, String opis,
            String sifraBanke, int idtipaTroska) {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("update isplata set "
                    + "samostalniPreduzetnikJIB=?, "
                    + "komitentJIB=?, "
                    + "datum=?, "
                    + "ulaznaFakturaId=?, "
                    + "brojDokumenta=?, "
                    + "iznos=?, "
                    + "opis=?, "
                    + "sifrabanke=?, "
                    + "idtipatroska=? "
                    + "where id="+id);
           ps.setString(1, samostalniPreduzetnikJIB);
           ps.setString(2, komitentJIB);
           ps.setDate(3, datum);
           ps.setInt(4, ulaznaFakturaId);
           ps.setString(5, brojDokumenta);
           ps.setDouble(6, iznos);
           ps.setString(7, opis);
           ps.setString(8, sifraBanke);
           ps.setInt(9, idtipaTroska);
           ps.executeUpdate();
            

        } catch (SQLException ex) {
            Logger.getLogger(IsplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IsplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            return true;    
  } 
   public boolean setIsplata
        (String samostalniPreduzetnikJIB, String komitentJIB, Date datum, 
            int ulaznaFakturaId, String brojDokumenta, double iznos, String opis, String sifraBanke,
            int idTipaTroska) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
           con = ConnectionPool.getInstance().checkOut();
           ps = con.prepareStatement("insert into isplata values(default,?,?,?,?,?,?,?,?,?)");
           ps.setString(1, samostalniPreduzetnikJIB);
           ps.setString(2, komitentJIB);
           ps.setDate(3,datum);
           ps.setInt(4, ulaznaFakturaId);
           ps.setString(5, brojDokumenta);
           ps.setDouble(6, iznos);
           ps.setString(7, opis);
           ps.setString(8, sifraBanke);
           ps.setInt(9, idTipaTroska);
           ps.execute();
            

        } catch (SQLException ex) {
            Logger.getLogger(IsplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IsplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            return true;    
  } 
        public static boolean removeIsplata(int id) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
           con = ConnectionPool.getInstance().checkOut();
           ps = con.prepareStatement("delete from isplata where id="+id);
           ps.execute();
            

        } catch (SQLException ex) {
            Logger.getLogger(IsplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IsplataDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            return true;    
  } 
}
