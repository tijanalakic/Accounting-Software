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
public class IzlaznaFakturaDTO {

    private Date datum;
    private double iznosFakture;
    private double iznosIzvoza;
    private double osnovicaZaPDV;
    private double ukupniPDV;
    private int idFakture;
    private String nazivFakture;
    private String samostalniPreduzetnikJIB;
    private String komitentJIB;
    private int idTipaPrihoda;
    private double iznosVanposlovneSvrhe;
    private double iznosOstalo;

    public IzlaznaFakturaDTO(int idFakture, String samostalniPreduzetnikJIB,String nazivFakture,
            Date datum,String komitentJIB,double iznosFakture, double iznosVanposlovneSvrhe,
            double iznosIzvoza,double iznosOstalo, double osnovicaZaPDV,double ukupniPDV,  int idTipaPrihoda) {
        this.datum = datum;
        this.iznosFakture = iznosFakture;
        this.iznosIzvoza = iznosIzvoza;
        this.osnovicaZaPDV = osnovicaZaPDV;
        this.ukupniPDV = ukupniPDV;
        this.idFakture = idFakture;
        this.nazivFakture = nazivFakture;
        this.samostalniPreduzetnikJIB = samostalniPreduzetnikJIB;
        this.komitentJIB = komitentJIB;
        this.idTipaPrihoda = idTipaPrihoda;
        this.iznosVanposlovneSvrhe = iznosVanposlovneSvrhe;
        this.iznosOstalo = iznosOstalo;
        
    }


    public String getKomitentJIB() {
        return komitentJIB;
    }

    public void setKomitentJIB(String komitentJIB) {
        this.komitentJIB = komitentJIB;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getIznosFakture() {
        return iznosFakture;
    }

    public void setIznosFakture(double iznosFakture) {
        this.iznosFakture = iznosFakture;
    }

    public double getIznosIzvoza() {
        return iznosIzvoza;
    }

    public void setIznosIzvoza(double iznosIzvoza) {
        this.iznosIzvoza = iznosIzvoza;
    }

    public double getOsnovicaZaPDV() {
        return osnovicaZaPDV;
    }

    public void setOsnovicaZaPDV(double osnovicaZaPDV) {
        this.osnovicaZaPDV = osnovicaZaPDV;
    }

    public double getUkupniPDV() {
        return ukupniPDV;
    }

    public void setUkupniPDV(double ukupniPDV) {
        this.ukupniPDV = ukupniPDV;
    }

    public int getIdFakture() {
        return idFakture;
    }

    public void setIdFakture(int idFakture) {
        this.idFakture = idFakture;
    }

    public String getNazivFakture() {
        return nazivFakture;
    }

    public void setNazivFakture(String nazivFakture) {
        this.nazivFakture = nazivFakture;
    }

    public String getSamostalniPreduzetnikJIB() {
        return samostalniPreduzetnikJIB;
    }

    public void setSamostalniPreduzetnikJIB(String samostalniPreduzetnikJIB) {
        this.samostalniPreduzetnikJIB = samostalniPreduzetnikJIB;
    }


    public int getIdTipaPrihoda() {
        return idTipaPrihoda;
    }

    public void setIdTipaPrihoda(int idTipaPrihoda) {
        this.idTipaPrihoda = idTipaPrihoda;
    }

    public double getIznosVanposlovneSvrhe() {
        return iznosVanposlovneSvrhe;
    }

    public void setIznosVanposlovneSvrhe(double iznosVanposlovneSvrhe) {
        this.iznosVanposlovneSvrhe = iznosVanposlovneSvrhe;
    }

    public double getIznosOstalo() {
        return iznosOstalo;
    }

    public void setIznosOstalo(double iznosOstalo) {
        this.iznosOstalo = iznosOstalo;
    }
    
    
}
