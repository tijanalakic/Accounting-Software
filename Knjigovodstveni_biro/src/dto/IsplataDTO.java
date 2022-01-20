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
public class IsplataDTO {
  private int id;
  private String samostalniPreduzetnikJIB;
  private String komitentJIB;
  private Date datum;
  private int ulaznaFakturaId;
  private String  brojDokumenta;
  private double iznos;
  private String opis;
  private String sifraBanke;
  private int idTipaTroska;

    public IsplataDTO(int id, String samostalniPreduzetnikJIB, String komitentJIB, Date datum, 
            int ulaznaFakturaId, String brojDokumenta, double iznos, String opis, String sifraBanke,
            int idTipaTroska) {
        this.id = id;
        this.samostalniPreduzetnikJIB = samostalniPreduzetnikJIB;
        this.komitentJIB = komitentJIB;
        this.datum = datum;
        this.ulaznaFakturaId = ulaznaFakturaId;
        this.brojDokumenta = brojDokumenta;
        this.iznos = iznos;
        this.opis = opis;
        this.sifraBanke = sifraBanke;
        this.idTipaTroska = idTipaTroska;
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

    public int getUlaznaFakturaId() {
        return ulaznaFakturaId;
    }

    public void setUlaznaFakturaId(int ulaznaFakturaId) {
        this.ulaznaFakturaId = ulaznaFakturaId;
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

    public int getIdTipaTroska() {
        return idTipaTroska;
    }

    public void setIdTipaTroska(int idTipaTroska) {
        this.idTipaTroska = idTipaTroska;
    }

}
