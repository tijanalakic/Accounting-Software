/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Tijana Lakic
 */
public class SamostalniPreduzetnikImaKomitentaDTO {
  private int idTipa;
  private String samostalniPreduzetnikJIB;
  private String komitentJIB;

    public SamostalniPreduzetnikImaKomitentaDTO(int idTipa, String samostalniPreduzetnikJIB, String komitentJIB) {
        this.idTipa = idTipa;
        this.samostalniPreduzetnikJIB = samostalniPreduzetnikJIB;
        this.komitentJIB = komitentJIB;
    }

    public int getIdTipa() {
        return idTipa;
    }

    public void setIdTipa(int idTipa) {
        this.idTipa = idTipa;
    }

    public String getSamostalniPreduzetnikJIB() {
        return samostalniPreduzetnikJIB;
    }

    public void setSamostalniPreduzetnikJIB(String samostalniPreduzetnikJIB) {
        this.samostalniPreduzetnikJIB = samostalniPreduzetnikJIB;
    }

    public String getKomitentJIB() {
        return komitentJIB;
    }

    public void setKomitentJIB(String komitentJIB) {
        this.komitentJIB = komitentJIB;
    }
  
  
}
