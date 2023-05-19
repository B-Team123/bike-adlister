USE adlister_db;

DROP TABLE IF EXISTS ads_feat_join;
DROP TABLE IF EXISTS users_address;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS features;

create table features
(
    id int auto_increment primary key,
    name int null
);

create table users
(
    id int auto_increment primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    phone_number int null,
    avatar_url varchar(255) null,
    constraint email unique (email),
    constraint username unique (username)
);

create table ads
(
    id int auto_increment primary key,
    user_id int not null,
    title varchar(255) not null,
    description text not null,
    price double not null,
    size varchar(50) null,
    type varchar(255) null,
    foreign key (user_id) references users (id)
);

create table ads_feat_join
(
    ad_id_fk   int null,
    feat_id_fk int null,
    constraint ads_feat_join_ads_id_fk
    foreign key (ad_id_fk) references ads (id),
    constraint feat_ads_join_fk
    foreign key (feat_id_fk) references features (id)
);

create table users_address
(
    id int auto_increment primary key,
    street_address varchar(255) null,
    city varchar(50) not null,
    state varchar(2) not null,
    zip_code int not null,
    users_id int not null,
    constraint users_address_users_id_fk
    foreign key (users_id) references users (id)
);




