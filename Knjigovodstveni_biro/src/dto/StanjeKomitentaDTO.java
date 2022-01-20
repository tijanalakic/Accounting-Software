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
public class StanjeKomitentaDTO {
  private String samostalniPreduzetnikJIB;
  private String komitentJIB;
  private double duguje;
  private double potrazuje;
  private double saldo;

    public StanjeKomitentaDTO(String samostalniPreduzetnikJIB, String komitentJIB, double duguje, double potrazuje, double saldo) {
        this.samostalniPreduzetnikJIB = samostalniPreduzetnikJIB;
        this.komitentJIB = komitentJIB;
        this.duguje = duguje;
        this.potrazuje = potrazuje;
        this.saldo = saldo;
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

    public double getDuguje() {
        return duguje;
    }

    public void setDuguje(double duguje) {
        this.duguje = duguje;
    }

    public double getPotrazuje() {
        return potrazuje;
    }

    public void setPotrazuje(double potrazuje) {
        this.potrazuje = potrazuje;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
  
}
