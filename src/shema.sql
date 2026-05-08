create table Genres(
    id int primary key ,
    genre varchar(100) not null,
    isactive boolean not null default 1
);

create table Movies(
    id int primary key,
    genre_id int not null,
    Title varchar(100) not null,
    isactive boolean not null default 1,

    constraint fk_Movies_Genres foreign key(genre_id) references Genres(id)
);

create table Clients(
    id int primary key,
    Fullname varchar(50) not null,
    isactive boolean not null default 1
);

create table Rentals(
    id int primary key,
    client_id int not null,
    movie_id int not null,
    Returned boolean not null default 0,

    constraint fk_Rentals_Clients foreign key(client_id) references Clients(id),
    constraint fk_Rentals_Movies foreign key(movie_id) references Movies(id)

);