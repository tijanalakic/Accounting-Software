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

    
  public class KomitentWrapperDTO {
  private String jib;
  private String naziv;
  private boolean pdvSistem;
  private String adresa;
  private String postanskiBroj;
  private String mjesto;
  private String telefon;
  private String ziroRacun;
  private double saldo;
  private String sifraBanke;
  private int tipKomitenta;

    public KomitentWrapperDTO(String spJib, String jib, String naziv, boolean pdvSistem, String adresa, String postanskiBroj,
            String telefon, String ziroRacun, int tipKomitenta, String sifraBanke) {
        this.jib = jib;
        this.naziv = naziv;
        this.pdvSistem = pdvSistem;
        this.adresa = adresa;
        this.postanskiBroj = postanskiBroj;
        this.telefon = telefon;
        this.ziroRacun = ziroRacun;
        this.saldo = 0;
        this.sifraBanke = sifraBanke;
        this.tipKomitenta = tipKomitenta;
       }
    public KomitentWrapperDTO(KomitentDTO k,String mjesto,String brojRacuna,Double saldo){
        
        this.jib = k.getJib();
        this.naziv =k.getNaziv();
        this.mjesto = mjesto;
        this.ziroRacun = brojRacuna;
        this.saldo=saldo;
        
    }

   public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    public boolean isPdvSistem() {
        return pdvSistem;
    }

    public void setPdvSistem(boolean pdvSistem) {
        this.pdvSistem = pdvSistem;
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

   public String getMjesto() {
        return mjesto;
    }

    public void setMjesto(String mjesto) {
        this.mjesto = mjesto;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getZiroRacun() {
        return ziroRacun;
    }

    public void setZiroRacun(String ziroRacun) {
        this.ziroRacun = ziroRacun;
    }

    public String getSifraBanke() {
        return sifraBanke;
    }

    public void setSifraBanke(String sifraBanke) {
        this.sifraBanke = sifraBanke;
    }

    public int getTipKomitenta() {
        return tipKomitenta;
    }

    public void setTipKomitenta(int tipKomitenta) {
        this.tipKomitenta = tipKomitenta;
    }
  
}
