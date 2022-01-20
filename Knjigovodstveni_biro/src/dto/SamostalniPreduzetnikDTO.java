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
public class SamostalniPreduzetnikDTO {
  private String jib;
  private String naziv;
  private String sjedisteFirme;
  private String sifraDjelatnosti;
  private String nazivDjelatnosti;
  private String jmb;
  private String ime;
  private String prezime;
  private String adresa;
  private String postanskiBroj;
 // private String ziroRacun;

    public SamostalniPreduzetnikDTO(String jib, String naziv, String sjedisteFirme,
            String sifraDjelatnosti, String nazivDjelatnosti, String jmb, String ime, String prezime,
            String adresa, String postanskiBroj){  //, String ziroRacun) {
        this.jib = jib;
        this.naziv = naziv;
        this.sjedisteFirme = sjedisteFirme;
        this.sifraDjelatnosti = sifraDjelatnosti;
        this.nazivDjelatnosti = nazivDjelatnosti;
        this.jmb = jmb;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.postanskiBroj = postanskiBroj;
        //this.ziroRacun = ziroRacun;
    }

    public String getJib() {
        return jib;
    }

    public void setJib(String jib) {
        this.jib = jib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSjedisteFirme() {
        return sjedisteFirme;
    }

    public void setSjedisteFirme(String sjedisteFirme) {
        this.sjedisteFirme = sjedisteFirme;
    }

    public String getSifraDjelatnosti() {
        return sifraDjelatnosti;
    }

    public void setSifraDjelatnosti(String sifraDjelatnosti) {
        this.sifraDjelatnosti = sifraDjelatnosti;
    }

    public String getNazivDjelatnosti() {
        return nazivDjelatnosti;
    }

    public void setNazivDjelatnosti(String nazivDjelatnosti) {
        this.nazivDjelatnosti = nazivDjelatnosti;
    }

    public String getJmb() {
        return jmb;
    }

    public void setJmb(String jmb) {
        this.jmb = jmb;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

   /* public String getZiroRacun() {
        return ziroRacun;
    }

    public void setZiroRacun(String ziroRacun) {
        this.ziroRacun = ziroRacun;
    }*/

    
}
