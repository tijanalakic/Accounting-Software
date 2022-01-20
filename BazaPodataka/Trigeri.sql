use mydb;
drop trigger if exists izlazna_duguje;
delimiter $$
create
trigger izlazna_duguje after insert
on izlazna_faktura
for each row
begin
declare vduguje decimal;

select stanje_komitenta.Duguje into vduguje from stanje_komitenta where new.SamostalniPreduzetnikJIB=stanje_komitenta.SamostalniPreduzetnikJIB
and new.KomitentJIB=stanje_komitenta.KomitentJIB;

update stanje_komitenta
set
stanje_komitenta.Duguje=vduguje+new.IznosFakture,
stanje_komitenta.Saldo=vduguje+new.IznosFakture-stanje_komitenta.Potrazuje
where new.SamostalniPreduzetnikJIB=stanje_komitenta.SamostalniPreduzetnikJIB
and new.KomitentJIB=stanje_komitenta.KomitentJIB;
end $$
delimiter ;




use mydb;
drop trigger if exists ulazna_potrazuje;
delimiter $$
create
trigger ulazna_potrazuje after insert
on ulazna_faktura
for each row
begin
declare vpotrazuje decimal;

select stanje_komitenta.Potrazuje into vpotrazuje from stanje_komitenta where new.SamostalniPreduzetnikJIB=stanje_komitenta.SamostalniPreduzetnikJIB
and new.KomitentJIB=stanje_komitenta.KomitentJIB;

update stanje_komitenta
set
stanje_komitenta.Potrazuje=vpotrazuje+new.UkupnoSaPDV,
stanje_komitenta.Saldo=stanje_komitenta.Duguje-new.UkupnoSaPDV-vpotrazuje
where new.SamostalniPreduzetnikJIB=stanje_komitenta.SamostalniPreduzetnikJIB
and new.KomitentJIB=stanje_komitenta.KomitentJIB;
end $$
delimiter ;





use mydb;
drop trigger if exists uplata_potrazuje;
delimiter $$
create
trigger uplata_potrazuje after insert
on uplata
for each row
begin
declare vpotrazuje decimal;

select stanje_komitenta.Potrazuje into vpotrazuje from stanje_komitenta where new.SamostalniPreduzetnikJIB=stanje_komitenta.SamostalniPreduzetnikJIB
and new.KomitentJIB=stanje_komitenta.KomitentJIB;

update stanje_komitenta
set
stanje_komitenta.Potrazuje=vpotrazuje+new.iznos,
stanje_komitenta.Saldo=stanje_komitenta.Duguje-new.iznos-vpotrazuje
where new.SamostalniPreduzetnikJIB=stanje_komitenta.SamostalniPreduzetnikJIB
and new.KomitentJIB=stanje_komitenta.KomitentJIB;
end $$
delimiter ;








use mydb;
drop trigger if exists isplata_duguje;
delimiter $$
create
trigger isplata_duguje after insert
on isplata
for each row
begin
declare vduguje decimal;

select stanje_komitenta.Duguje into vduguje from stanje_komitenta where new.SamostalniPreduzetnikJIB=stanje_komitenta.SamostalniPreduzetnikJIB
and new.KomitentJIB=stanje_komitenta.KomitentJIB;

update stanje_komitenta
set
stanje_komitenta.Duguje=vduguje+new.Iznos,
stanje_komitenta.Saldo=vduguje+new.Iznos-stanje_komitenta.Potrazuje
where new.SamostalniPreduzetnikJIB=stanje_komitenta.SamostalniPreduzetnikJIB
and new.KomitentJIB=stanje_komitenta.KomitentJIB;
end $$
delimiter ;
