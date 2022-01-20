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
public class KomitentDTO {
  private String jib;
  private String naziv;
  private boolean pdvSistem;
  private String adresa;
  private String postanskiBroj;


    public KomitentDTO(String jib, String naziv, boolean pdvSistem, String adresa,  String postanskiBroj){
        

        this.jib = jib;
        this.naziv = naziv;
        this.pdvSistem = pdvSistem;
        this.adresa = adresa;
        this.postanskiBroj = postanskiBroj;
      
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


  
}
