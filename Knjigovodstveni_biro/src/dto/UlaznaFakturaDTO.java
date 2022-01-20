/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author Tijana Lakic
 */
public class UlaznaFakturaDTO {
  private int id;
  private String samostalniPreduzetnikJIB;
  private String nazivFakture;
  private Date datum;
  private String komitentJIB;
  private double iznosBezPDV;
  private double ukupnoSaPDV;
  private double iznosPausalneNaknade;
  private double ukupanUlazniPorez;
  private double ulazniPorezOdbitni;
  private double ulazniPorezNeodbitni;
  private int idTipaTroska;
  private boolean uvoz;
  private boolean gotovina;

    public UlaznaFakturaDTO(int idFakture,String samostalniPreduzetnikJIB, String nazivFakture, Date datum, String komitentJIB,
            double iznosBezPDV, double ukupnoSaPDV, double iznosPausalneNaknade, double ukupanUlazniPorez, 
            double ulazniPorezOdbitni, double ulazniPorezNeodbitni, int idTipaTroska, boolean uvoz, 
            boolean gotovina) {
        this.id=idFakture;
        this.samostalniPreduzetnikJIB = samostalniPreduzetnikJIB;
        this.nazivFakture = nazivFakture;
        this.datum = datum;
        this.komitentJIB = komitentJIB;
        this.iznosBezPDV = iznosBezPDV;
        this.ukupnoSaPDV = ukupnoSaPDV;
        this.iznosPausalneNaknade = iznosPausalneNaknade;
        this.ukupanUlazniPorez = ukupanUlazniPorez;
        this.ulazniPorezOdbitni = ulazniPorezOdbitni;
        this.ulazniPorezNeodbitni = ulazniPorezNeodbitni;
        this.idTipaTroska = idTipaTroska;
        this.uvoz = uvoz;
        this.gotovina = gotovina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSamostalniPreduzetnikJIB() {
        return samostalniPreduzetnikJIB;
    }

    public void setSamostalniPreduzetnikJIB(String samostalniPreduzetnikJIB) {
        this.samostalniPreduzetnikJIB = samostalniPreduzetnikJIB;
    }

    public String getNazivFakture() {
        return nazivFakture;
    }

    public void setNazivFakture(String nazivFakture) {
        this.nazivFakture = nazivFakture;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getKomitentJIB() {
        return komitentJIB;
    }

    public void setKomitentJIB(String komitentJIB) {
        this.komitentJIB = komitentJIB;
    }

    public double getIznosBezPDV() {
        return iznosBezPDV;
    }

    public void setIznosBezPDV(double iznosBezPDV) {
        this.iznosBezPDV = iznosBezPDV;
    }

    public double getUkupnoSaPDV() {
        return ukupnoSaPDV;
    }

    public void setUkupnoSaPDV(double ukupnoSaPDV) {
        this.ukupnoSaPDV = ukupnoSaPDV;
    }

    public double getIznosPausalneNaknade() {
        return iznosPausalneNaknade;
    }

    public void setIznosPausalneNaknade(double iznosPausalneNaknade) {
        this.iznosPausalneNaknade = iznosPausalneNaknade;
    }

    public double getUkupanUlazniPorez() {
        return ukupanUlazniPorez;
    }

    public void setUkupanUlazniPorez(double ukupanUlazniPorez) {
        this.ukupanUlazniPorez = ukupanUlazniPorez;
    }

    public double getUlazniPorezOdbitni() {
        return ulazniPorezOdbitni;
    }

    public void setUlazniPorezOdbitni(double ulazniPorezOdbitni) {
        this.ulazniPorezOdbitni = ulazniPorezOdbitni;
    }

    public double getUlazniPorezNeodbitni() {
        return ulazniPorezNeodbitni;
    }

    public void setUlazniPorezNeodbitni(double ulazniPorezNeodbitni) {
        this.ulazniPorezNeodbitni = ulazniPorezNeodbitni;
    }

    public int getIdTipaTroska() {
        return idTipaTroska;
    }

    public void setIdTipaTroska(int idTipaTroska) {
        this.idTipaTroska = idTipaTroska;
    }

    public boolean isUvoz() {
        return uvoz;
    }

    public void setUvoz(boolean uvoz) {
        this.uvoz = uvoz;
    }

    public boolean isGotovina() {
        return gotovina;
    }

    public void setGotovina(boolean gotovina) {
        this.gotovina = gotovina;
    }
  
}
