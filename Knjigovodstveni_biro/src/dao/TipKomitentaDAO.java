/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.TipKomitentaDTO;
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
public class TipKomitentaDAO {
    
    public static ObservableList<TipKomitentaDTO> getTipoveKomitenata() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<TipKomitentaDTO> tipoviKomitenata = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            ps = con.prepareStatement("select * from tip_komitenta");
            rs = ps.executeQuery();

            while (rs.next()) {
                int idTipa = rs.getInt(1);
                String nazivTipa=rs.getString(2);
                
                tipoviKomitenata.add(new TipKomitentaDTO(idTipa, nazivTipa));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipKomitentaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            return FXCollections.observableArrayList(tipoviKomitenata);
    }
}
