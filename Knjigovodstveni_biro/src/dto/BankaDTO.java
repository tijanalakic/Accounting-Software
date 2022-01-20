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
public class BankaDTO {
    
    private String sifraBanke;
    private String nazivBanke;

    public BankaDTO(String sifraBanke, String nazivBanke) {
        this.sifraBanke = sifraBanke;
        this.nazivBanke = nazivBanke;
    }

    public String getSifraBanke() {
        return sifraBanke;
    }

    public void setSifraBanke(String sifraBanke) {
        this.sifraBanke = sifraBanke;
    }

    public String getNazivBanke() {
        return nazivBanke;
    }

    public void setNazivBanke(String nazivBanke) {
        this.nazivBanke = nazivBanke;
    }
    

  
    
}
