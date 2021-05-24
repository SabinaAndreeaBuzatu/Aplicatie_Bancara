drop schema banca;
create schema banca;
drop table Client;
drop table Cont;
drop table ContCurent;
DROP TABLE cutie;
drop table depozit;
drop table card;
drop table credit;

create table Client (
CNP varchar(15) NOT NULL,
nume varchar(15) not null,
prenume varchar(15) not null,
data_nasterii varchar(20),
primary key(CNP)
);

create table Card (
Nr varchar(20) NOT NULL,
IBANcc varchar(30),
IBANd  varchar(30),
IBANc  varchar(30),
pin varchar(4) not null,
data_exp varchar(11),
cvv varchar(3) not null,
primary key(Nr)
);
alter table Card add constraint one_fk_not_null
    check (IBANcc is not null xor IBANd is null xor IBANc is null);
create table ContCurent (
IBAN varchar(30) NOT NULL,
CNP varchar(15) NOT NULL,
valuta varchar(3) not null,
sold double not null,
data_acordare varchar(11),
tip_cont varchar(15) not null,
comision double,
primary key(IBAN)
);

create table Cutie (
Nr varchar(37) NOT NULL,
IBAN varchar(30) NOT NULL,
prag double not null,
data_des varchar(11),
adresa varchar(100) not null,
valuta varchar(3) not null,
primary key(Nr)
);

create table Depozit (
IBAN varchar(30) NOT NULL,
IBANC varchar(30) NOT NULL,
valuta varchar(3) not null,
sold double not null,
data_acordare varchar(11),
tip_cont varchar(15) not null,
comision double,
dobanda double,
primary key(IBAN)
);
create table Credit (
IBAN varchar(30) NOT NULL,
IBANC varchar(30) NOT NULL,
valuta varchar(3) not null,
sold double not null,
data_acordare varchar(11),
tip_cont varchar(30) not null,
comision double,
dobanda double,
durataLuni int not null,
rata double,
ratePlatite int,
suma_acordata double,
primary key(IBAN)
);
alter table ContCurent 
add constraint fkcc
foreign key(CNP)
REFERENCES Client(CNP)
on delete cascade;

alter table Card
add constraint fkcard
foreign key(IBANcc) references contcurent(IBAN)
on delete cascade;

alter table Card
add constraint fkcardc
foreign key(IBANc) references credit(IBAN)
on delete cascade;

alter table Card
add constraint fkcardd
foreign key(IBANd) references depozit(IBAN)
on delete cascade;

alter table Depozit 
add constraint fkd
foreign key(IBANc)
REFERENCES contcurent(IBAN )
on delete cascade;

alter table Credit
add constraint fkc
foreign key(IBANc)
REFERENCES contcurent(IBAN )
on delete cascade;

alter table Cutie 
add constraint fkcu
foreign key(IBAN)
REFERENCES contcurent(IBAN )
on delete cascade;

insert into client values ('60056722156888',"Dumitrescu","Elena","12/09/1999");
delete from client;
select * from contcurent;
select * from client;
select * from depozit;
select * from card;
select * from cutie;
select * from cARD;