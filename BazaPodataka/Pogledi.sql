
#izlazna_faktura_view
create view izlazna_faktura_view as
SELECT i.id,SamostalniPreduzetnikJIB,s.naziv as nazivsp, nazivfakture, datum, k.naziv as nazivk, KomitentJIB, IznosFakture,IznosVanposlovneSvrhe, IznosIzvoza, OsnovicaZaPDV, UkupniPDV, IdTipaPrihoda, t.naziv as nazivt
 FROM mydb.izlazna_faktura i 
									join komitent k on i.komitentJIB = k.JIB
									join samostalni_preduzetnik s on s.jib = i.samostalniPreduzetnikJIB
									join tip_prihoda t on i.idTipaPrihoda = t.id;
                                     
     #ulazna_faktura_view
create view ulazna_faktura_view as                                
                                     select u.id,SamostalniPreduzetnikJIB,s.naziv as nazivsp, nazivfakture, datum, k.naziv as nazivk, KomitentJIB, iznosbezpdv,ukupnosapdv,  iznospausalnenaknade,ukupanulazniporez,ulazniporezodbitni,ulazniporezneodbitni, idtipatroska,t.naziv,uvoz, gotovina
									from ulazna_faktura u
									join komitent k on komitentJIB = k.JIB
									join samostalni_preduzetnik s on s.jib = samostalniPreduzetnikJIB
									join tip_troska t on idTipaTroska = t.id;
                                     
                                     
        #komtetent_view
create view komitent_view as                              
                                     SELECT k.jib,k.naziv as nazivKomitenta,PDVsistem,k.Adresa,m.Naziv as Mjesto, t.BrojTelefona,z.BrojRacuna
                                     from komitent k
                                     join mjesto m on m.postanskibroj=k.postanskibroj
                                     join telefon_komitenta t on t.jib=k.jib
                                     join ziro_racun_komitenta z on z.jib=k.jib;

#sp_kom_viewsamostalni_preduzetnik
create view sp_komitent_view as
                                     SELECT s.JIB, s.Naziv, tip.NazivTipa, k_v.jib as JIBkomiteta,k_v.NazivKomitenta,k_v.PDVsistem,k_v.Mjesto,k_v.BrojRacuna,stanje.Saldo
                                     from samostalni_preduzetnik s
                                     join samostalni_preduzetnik_ima_komitent s_k on s.jib=s_k.samostalnipreduzetnikjib
                                     join tip_komitenta tip on tip.idtipa=s_k.idtipa
                                     join komitent_view k_v on k_v.jib=s_k.KomitentJIB 
                                     join stanje_komitenta stanje on stanje.SamostalniPreduzetnikJIb=s.jib and stanje.komitentjib=k_v.jib;
CREATE VIEW `sp_view` AS
    SELECT 
        `s`.`JIB` AS `jib`,
        `s`.`Naziv` AS `naziv`,
        `s`.`SjedisteFirme` AS `sjedisteFirme`,
        `s`.`SifraDjelatnosti` AS `sifraDjelatnosti`,
        `s`.`NazivDjelatnosti` AS `nazivDjelatnosti`,
        `s`.`JMB` AS `jmb`,
        `s`.`Ime` AS `ime`,
        `s`.`Prezime` AS `prezime`,
        `s`.`Adresa` AS `adresa`,
        `s`.`PostanskiBroj` AS `postanskiBroj`,
        `z`.`BrojRacuna` AS `brojRacuna`
    FROM
        (`samostalni_preduzetnik` `s`
        JOIN `ziro_racun_sp` `z` ON ((`s`.`JIB` = `z`.`JIB`)))