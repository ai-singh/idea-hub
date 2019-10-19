create table users
(
    username varchar(20) not null,
    password varchar(20) not null,
    cuny_id integer not null primary key
);


create table ideas
(
    id integer auto_increment primary key,
    title varchar(30) not null,
    description varchar(2000) not null,
    upvotes integer
);

insert into users values('Arpit', 'abcd', 1234);
insert into users values('Eudes', 'abcd', 2345);
insert into users values('Samir', 'abcd', 3456);

insert into ideas values(1, 'Test', 'Test Description', 0);
insert into ideas values(2, 'Test2', 'Test Description2', 1);
insert into ideas values(3, 'Test3', 'Test Description3', 0);
