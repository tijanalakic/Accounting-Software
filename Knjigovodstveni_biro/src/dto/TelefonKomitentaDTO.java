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
public class TelefonKomitentaDTO {
    private String brojTelefona;
    private String jib;

    public TelefonKomitentaDTO(String brojTelefona, String jib) {
        this.brojTelefona = brojTelefona;
        this.jib = jib;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getJib() {
        return jib;
    }

    public void setJib(String jib) {
        this.jib = jib;
    }
    
}
