drop table if exists experts;
create table experts
(
    id      int primary key auto_increment,
    name    varchar(100) not null,
    surname varchar(100) not null
);
