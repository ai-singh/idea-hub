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
    upvotes integer,
    posted_time varchar(100)
);


create table upvotes
(
    cuny_id integer not null,
    id integer
);

insert into users values('Arpit', 'abcd', 1234);
insert into users values('Eudes', 'abcd', 2345);
insert into users values('Samir', 'abcd', 3456);

insert into ideas values(1, 'Test', 'Test Description', 0, '2 hours ago');
insert into ideas values(2, 'Test2', 'Test Description2', 1, '3 days ago');
insert into ideas values(3, 'Test3', 'Test Description3', 3, '20 hours ago');
insert into ideas values(4, 'Test3', 'Test Description3', 2, 'A minute ago');
insert into ideas values(5, 'Test3', 'Test Description3', 1, '10 days ago');
insert into ideas values(6, 'Test3', 'Test Description3', 5, '18 hours ago');
insert into ideas values(7, 'Test3', 'Test Description3', 6, '6 minutes ago');

insert into upvotes values(1234, 1);
insert into upvotes values(1234, 4);
insert into upvotes values(2345, 1);
insert into upvotes values(2345, 3);

