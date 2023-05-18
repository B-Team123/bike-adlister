USE adlister_db;

DROP TABLE IF EXISTS ads_categories_join;
DROP TABLE IF EXISTS users_address;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;

create table categories
(
    id int auto_increment primary key,
    size varchar(50),
    types varchar(255)
);

create table users
(
    id int auto_increment primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    phone_number int,
    avatar_url varchar(255),
    constraint email unique (email),
    constraint username unique (username)
);

create table ads
(
    id int auto_increment primary key,
    user_id int not null,
    title varchar(255) not null,
    description TEXT not null,
    price double not null,
    constraint ads_users_id_fk
    foreign key (user_id) references users (id)
);

create table ads_categories_join
(
    ads_id_fk int,
    categories_id_fk int,
    constraint ads_categories_join_ads_id_fk
    foreign key (ads_id_fk) references ads (id),
    constraint ads_categories_join_categories_id_fk
    foreign key (categories_id_fk) references categories (id)
);

create table users_address
(
    id int auto_increment primary key,
    street_address varchar(255),
    city varchar(50) not null,
    state varchar(2) not null,
    zip_code int not null,
    users_id int not null ,
    constraint users_address_users_id_fk
    foreign key (users_id) references users (id)
);


