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
public class PDVprijavaDTO {
    
    private double isporuke,izvoz,oslobodjen,pdvIzlaz,nabavke,uvoz,poljoprivrednik,pdvUlaz,pdvUvoz,
            pausalnaNaknada,ukupanPDVulaz,razlikaIzlazUlaz,rs;
    
    public PDVprijavaDTO(){}
    public PDVprijavaDTO(double isporuke, double izvoz, double oslobodjen,
            double pdvIzlaz, double nabavke, double uvoz, double poljoprivrednik, double pdvUlaz, double pdvUvoz,
            double pausalnaNaknada, double ukupanPDVulaz, double razlikaIzlazUlaz,double rs) {
      
        this.isporuke = isporuke;
        this.izvoz = izvoz;
        this.oslobodjen = oslobodjen;
        this.pdvIzlaz = pdvIzlaz;
        this.nabavke = nabavke;
        this.uvoz = uvoz;
        this.poljoprivrednik = poljoprivrednik;
        this.pdvUlaz = pdvUlaz;
        this.pdvUvoz = pdvUvoz;
        this.pausalnaNaknada = pausalnaNaknada;
        this.ukupanPDVulaz = ukupanPDVulaz;
        this.razlikaIzlazUlaz = razlikaIzlazUlaz;
        this.rs=rs;
      
    }

    public double getRs() {
        return rs;
    }

    public void setRs(double rs) {
        this.rs = rs;
    }

 


    public double getIsporuke() {
        return isporuke;
    }

    public void setIsporuke(double isporuke) {
        this.isporuke = isporuke;
    }

    public double getIzvoz() {
        return izvoz;
    }

    public void setIzvoz(double izvoz) {
        this.izvoz = izvoz;
    }

    public double getOslobodjen() {
        return oslobodjen;
    }

    public void setOslobodjen(double oslobodjen) {
        this.oslobodjen = oslobodjen;
    }

    public double getPdvIzlaz() {
        return pdvIzlaz;
    }

    public void setPdvIzlaz(double pdvIzlaz) {
        this.pdvIzlaz = pdvIzlaz;
    }

    public double getNabavke() {
        return nabavke;
    }

    public void setNabavke(double nabavke) {
        this.nabavke = nabavke;
    }

    public double getUvoz() {
        return uvoz;
    }

    public void setUvoz(double uvoz) {
        this.uvoz = uvoz;
    }

    public double getPoljoprivrednik() {
        return poljoprivrednik;
    }

    public void setPoljoprivrednik(double poljoprivrednik) {
        this.poljoprivrednik = poljoprivrednik;
    }

    public double getPdvUlaz() {
        return pdvUlaz;
    }

    public void setPdvUlaz(double pdvUlaz) {
        this.pdvUlaz = pdvUlaz;
    }

    public double getPdvUvoz() {
        return pdvUvoz;
    }

    public void setPdvUvoz(double pdvUvoz) {
        this.pdvUvoz = pdvUvoz;
    }

    public double getPausalnaNaknada() {
        return pausalnaNaknada;
    }

    public void setPausalnaNaknada(double pausalnaNaknada) {
        this.pausalnaNaknada = pausalnaNaknada;
    }

    public double getUkupanPDVulaz() {
        return ukupanPDVulaz;
    }

    public void setUkupanPDVulaz(double ukupanPDVulaz) {
        this.ukupanPDVulaz = ukupanPDVulaz;
    }

    public double getRazlikaIzlazUlaz() {
        return razlikaIzlazUlaz;
    }

    public void setRazlikaIzlazUlaz(double razlikaIzlazUlaz) {
        this.razlikaIzlazUlaz = razlikaIzlazUlaz;
    }

   
    
    
}
