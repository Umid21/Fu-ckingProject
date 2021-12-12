drop table if exists producer cascade;


create table if not exists producer (
    id integer not null,
    name varchar(255),
    address varchar(255),
    primary key (id)
);


