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
public class ZiroRacunKomitentaDTO {
     private String brojRacuna;
    private String jib;

    public ZiroRacunKomitentaDTO(String brojRacuna, String jib) {
        this.brojRacuna = brojRacuna;
        this.jib = jib;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public String getJib() {
        return jib;
    }

    public void setJib(String jib) {
        this.jib = jib;
    }
    
    
            
}
