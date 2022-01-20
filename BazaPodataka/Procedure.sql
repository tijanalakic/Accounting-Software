
--
-- Dumping routines for database 'mydb'
--
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodaj_komitenta`(in pjibSP char(13), in pidTip int,  in pjib char(13), in pnaziv varchar(45), in ppdvSistem boolean, in padresa varchar(45), in ppostanskiBroj char(5),
								  in pbrojTelefona char(13), in psifraBanke char(3), in pbrojRacuna char(16))
begin
insert into komitent (`JIB`, `Naziv`, `PDVsistem`, `Adresa`, `PostanskiBroj`) VALUES (pjib, pnaziv,ppdvSistem, padresa,ppostanskiBroj);
insert into samostalni_preduzetnik_ima_komitent(idTipa,samostalniPreduzetnikJIB,komitentJIB) values (pidTip,pjibSP,pjib);
insert into telefon_komitenta(BrojTelefona,JIB) values (pbrojTelefona,pjib);
insert into ziro_racun(brojRacuna,sifraBanke) values (pbrojRacuna,psifraBanke);
insert into ziro_racun_komitenta(brojRacuna,jib) values (pbrojRacuna,pjib);
insert into stanje_komitenta values(pjibSP,pjib,default,default,default);
end ;;
DELIMITER ;





DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodaj_radnika`( in pjmb char(13),  in pime varchar(45),in pprezime varchar(45),in padresa varchar(45), in ppostanskiBroj char(5),in pidStrucneSpreme int, in pbrojTelefona char(13), 
in psifraBanke char(3), in pbrojRacuna char(16),in pidPlata int,in pperiodOd Date,in pperiodDo Date,in pnetoPlata decimal,in pbrutoPlata decimal,in pdoprionsi decimal)
begin
INSERT INTO radnik (`JMB`, `Ime`, `Prezime`, `Adresa`, `PostanskiBroj`,IdStrucneSpreme) VALUES( pjmb, pime, pprezime, padresa,ppostanskiBroj,pidStrucneSpreme);
insert into telefon_radnika(BrojTelefona,JIB) values (pbrojTelefona,pjib);
insert into ziro_racun(brojRacuna,sifraBanke) values (pbrojRacuna,psifraBanke);
insert into ziro_racun_radnika(brojRacuna,jib) values (pbrojRacuna,pjib);
insert into plata_obracun(idPlata,JMB,PeriodOd,PeriodDo,NetoPlata,BrutoPlata,Doprinosi) VALUES (pidPlata,pjmb, pperiodOd,pperiodDo, pnetoPlata, pbrutoPlata, pdoprionsi);
end ;;
DELIMITER ;





DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodaj_samostalnog_preduzetnika`(in pjib char(13), in pnaziv varchar(45),  in psjedisteFirme varchar(45), in psifraDjelatnosti varchar(45), in pnazivDjelatnosti varchar(45), in pjmb char(13),  in pime varchar(45),
								  in pprezime varchar(45),in padresa varchar(45), in ppostanskiBroj char(5), in pbrojTelefona char(13), in psifraBanke char(3), in pbrojRacuna char(16))
begin
INSERT INTO `mydb`.`samostalni_preduzetnik` (`JIB`, `Naziv`, `SjedisteFirme`, `SifraDjelatnosti`, `NazivDjelatnosti`, `JMB`, `Ime`, `Prezime`, `Adresa`, `PostanskiBroj`) VALUES(pjib,pnaziv, psjedisteFirme, psifraDjelatnosti , pnazivDjelatnosti, JMB, Ime, Prezime, padresa,ppostanskiBroj);
insert into telefon_sp(BrojTelefona,JIB) values (pbrojTelefona,pjib);
insert into ziro_racun(brojRacuna,sifraBanke) values (pbrojRacuna,psifraBanke);
insert into ziro_racun_sp(brojRacuna,jib) values (pbrojRacuna,pjib);
end ;;
DELIMITER ;






DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isplate_od_do`(in pjibSP char(13),in pDatumOd date , in pDatumDo date, in pOpis varchar(45) )
begin
declare kraj boolean default false;
declare vSifraBanke char(3);
declare vIznos decimal;
declare vBrojDok varchar(45);
declare vJIBK char(13);
declare vTipTroska int;
declare vId int;


declare fakture_cursor cursor for select n.Id,n.NazivFakture, n.UkupnoSaPDV, n.IdTipaTroska,n.KomitentJIB,z.SifraBanke from ulazna_faktura n join ziro_racun_sp zsp on zsp.jib=n.samostalniPreduzetnikJIB join ziro_racun z on 
     z.BrojRacuna=zsp.BrojRacuna
    where (n.datum between pDatumOd and pDatumDo) and  n.samostalniPreduzetnikJIB=pjibSP;

declare continue handler for not found set kraj = true;

open fakture_cursor;
petlja: loop
		fetch fakture_cursor into vId, vBrojDok,vIznos,vTipTroska,vJIBK,vSifraBanke;
        if(kraj) then leave petlja;end if;
        
         insert into isplata values(default,pjibSP,vJIBK,pDatumDo,vId,vBrojDok,vIznos,pOpis,vSifraBanke,vTipTroska);
         
	end loop petlja;
close fakture_cursor;

end ;;
DELIMITER ;




DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isplate_sp_po_mjesecu`(in pjib char(13), in DatumOd date , in DatumDo date )
begin
	select * from isplata 
    where (datum between DatumOd and DatumDo) and isplata.SamostalniPreduzetnikJIB=pjib;

end ;;
DELIMITER ;




DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `izlazne_faktura_po_mjesecu`(in pjib char(13), in DatumOd date , in DatumDo date )
begin
	select * from izlazna_faktura n   
    where (datum between DatumOd and DatumDo) and izlazna_faktura.SamostalniPreduzetnikJIB=pjib 
    group by SamostalniPreduzetnikJIB;
end ;;
DELIMITER ;





DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `izlazne_faktura_sp_po_mjesecu`(in pjib char(13), in DatumOd date , in DatumDo date )
begin
	select * from izlazna_faktura  
    where (datum between DatumOd and DatumDo) and izlazna_faktura.SamostalniPreduzetnikJIB=pjib;

end ;;
DELIMITER ;





DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mjesecna_pdv_prijava`(in DatumOd date,in DatumDo date, in JIB char(13), out isporuke decimal, out izvoz decimal, out oslobodjen decimal,
 out pdvIzlaz decimal, out nabavke decimal, out pUvoz decimal, out poljoprivrednik decimal, out pdvUlaz decimal, out pdvUvoz decimal, out 
            pausalnaNaknada decimal, out ukupanPDVulaz decimal, out razlikaIzlazUlaz decimal,out rs decimal)
begin

	declare suma decimal;
    declare razlika decimal;
    
    
	select sum(OsnovicaZaPDV), sum(IznosIzvoza), sum(IznosOstalo), sum(UkupniPDV)  into isporuke, izvoz, oslobodjen, pdvIzlaz from izlazna_faktura
     where 
    (datum between DatumOd and DatumDo) and SamostalniPreduzetnikJIB=JIB
    group by SamostalniPreduzetnikJIB;
    
    select sum(ulazna_faktura.IznosBezPDV), sum(ulazna_faktura.UlazniPorezOdbitni)  into nabavke, pdvUlaz from ulazna_faktura
     where 
    (datum between DatumOd and DatumDo) and SamostalniPreduzetnikJIB=JIB and uvoz = 0
    group by SamostalniPreduzetnikJIB;
    
    
	select sum(ulazna_faktura.IznosBezPDV), sum(ulazna_faktura.UlazniPorezOdbitni)  into pUvoz, pdvUvoz from ulazna_faktura
     where 
    (datum between DatumOd and DatumDo) and SamostalniPreduzetnikJIB=JIB and uvoz = 1
    group by SamostalniPreduzetnikJIB;
    
	select sum(ulazna_faktura.UkupnoSaPDV), sum(ulazna_faktura.IznosPausalneNaknade)  into poljoprivrednik, pausalnaNaknada from ulazna_faktura
     where 
    (datum between DatumOd and DatumDo) and SamostalniPreduzetnikJIB=JIB and IznosPausalneNaknade > 0
    group by SamostalniPreduzetnikJIB;
   

	select sum(izlazna_faktura.ukupniPDV) into rs from izlazna_faktura 
    join komitent on izlazna_faktura.KomitentJIB=komitent.JIB where komitent.PDVsistem=0
    group by SamostalniPreduzetnikJIB; 
    
    
    set suma = pdvUlaz + pdvUvoz + pausalnaNaknada;
    select suma into ukupanPDVUlaz;
    set razlika = PDVIzlaz - ukupanPDVUlaz;
    select razlika into razlikaIzlazUlaz;
end ;;
DELIMITER ;






DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ulazne_faktura_sp_po_mjesecu`(in pjib char(13), in DatumOd date , in DatumDo date )
begin
	select * from ulazna_faktura  
    where (datum between DatumOd and DatumDo) and ulazna_faktura.SamostalniPreduzetnikJIB=pjib;

end ;;
DELIMITER ;







DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `uplate_od_do`(in pjibSP char(13),in pDatumOd date , in pDatumDo date, in pOpis varchar(45) )
begin
declare kraj boolean default false;
declare vSifraBanke char(3);
declare vIznos decimal;
declare vBrojDok varchar(45);
declare vJIBK char(13);
declare vTipPrihoda int;
declare vId int;


declare fakture_cursor cursor for select n.Id,n.NazivFakture, n.IznosFakture, n.IdTipaPrihoda,n.KomitentJIB,z.SifraBanke from izlazna_faktura n join ziro_racun_komitenta zk on zk.jib=n.KomitentJIB join ziro_racun z on 
     z.BrojRacuna=zk.BrojRacuna
    where (n.datum between pDatumOd and pDatumDo) and  n.samostalniPreduzetnikJIB=pjibSP;

declare continue handler for not found set kraj = true;

open fakture_cursor;
petlja: loop
		fetch fakture_cursor into vId, vBrojDok,vIznos,vTipPrihoda,vJIBK,vSifraBanke;
        if(kraj) then leave petlja;end if;
        
         insert into uplata values(default,pjibSP,vJIBK,pDatumDo,vId,vBrojDok,vIznos,pOpis,vSifraBanke,vTipPrihoda);
         
	end loop petlja;
close fakture_cursor;

end ;;
DELIMITER ;






DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `uplate_sp_po_mjesecu`(in pjib char(13), in DatumOd date , in DatumDo date )
begin
	select * from uplata 
    where (datum between DatumOd and DatumDo) and uplata.SamostalniPreduzetnikJIB=pjib;

end ;;
DELIMITER ;
