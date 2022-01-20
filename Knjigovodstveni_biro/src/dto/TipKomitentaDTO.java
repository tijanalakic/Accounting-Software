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
public class TipKomitentaDTO {
    private int idTipa;
    private String nazivTipa;

    public TipKomitentaDTO(int idTipa, String nazivTipa) {
        this.idTipa = idTipa;
        this.nazivTipa = nazivTipa;
    }

    public int getIdTipa() {
        return idTipa;
    }

    public void setIdTipa(int idTipa) {
        this.idTipa = idTipa;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }

    public void setNazivTipa(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }
    
    
}
