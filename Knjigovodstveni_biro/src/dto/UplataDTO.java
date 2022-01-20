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
public class UplataDTO {
  private int id;
  private String samostalniPreduzetnikJIB;
  private String komitentJIB;
  private Date datum;
  private int izlaznaFakturaId;
  private String brojDokumenta;
  private double iznos;
  private String opis;
  private String sifraBanke;
  private int idTipaPrihoda;

    public UplataDTO(int id, String samostalniPreduzetnikJIB, String komitentJIB,
            Date datum, int izlaznaFakturaId, String brojDokumenta, double iznos, String opis, String sifraBanke, int idTipaPrihoda) {
        this.id = id;
        this.samostalniPreduzetnikJIB = samostalniPreduzetnikJIB;
        this.komitentJIB = komitentJIB;
        this.datum = datum;
        this.izlaznaFakturaId = izlaznaFakturaId;
        this.brojDokumenta = brojDokumenta;
        this.iznos = iznos;
        this.opis = opis;
        this.sifraBanke = sifraBanke;
        this.idTipaPrihoda = idTipaPrihoda;
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

    public int getIzlaznaFakturaId() {
        return izlaznaFakturaId;
    }

    public void setIzlaznaFakturaId(int izlaznaFakturaId) {
        this.izlaznaFakturaId = izlaznaFakturaId;
    }

    public String getBrojDokumenta() {
        return brojDokumenta;
    }

    public void setBrojDokumenta(String brojDokumenta) {
        this.brojDokumenta = brojDokumenta;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSifraBanke() {
        return sifraBanke;
    }

    public void setSifraBanke(String sifraBanke) {
        this.sifraBanke = sifraBanke;
    }

    public int getIdTipaPrihoda() {
        return idTipaPrihoda;
    }

    public void setIdTipaPrihoda(int idTipaPrihoda) {
        this.idTipaPrihoda = idTipaPrihoda;
    }
  
}
