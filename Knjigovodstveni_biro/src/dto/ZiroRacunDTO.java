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
public class ZiroRacunDTO {
   
    private String brojRacuna;
    private String sifraBanke;

    public ZiroRacunDTO(String brojRacuna, String sifraBanke) {
        this.brojRacuna = brojRacuna;
        this.sifraBanke = sifraBanke;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public String getSifraBanke() {
        return sifraBanke;
    }

    public void setSifraBanke(String sifraBanke) {
        this.sifraBanke = sifraBanke;
    }
    
}
