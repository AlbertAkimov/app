ALTER TABLE users
    AUTO_INCREMENT = 0;
ALTER TABLE cards
    AUTO_INCREMENT = 0;
ALTER TABLE customers
    AUTO_INCREMENT = 0;
ALTER TABLE users_roles
    AUTO_INCREMENT = 0;
ALTER TABLE products
    AUTO_INCREMENT = 0;
ALTER TABLE type_prices
    AUTO_INCREMENT = 0;
ALTER TABLE prices
    AUTO_INCREMENT = 0;


#/////////////////////////////////UNITS//////////////////////////////////////////
create table if not exists units
(
    id          bigint auto_increment primary key,
    guid        varchar(36),
    unit_name   varchar(256) not null,
    status      varchar(25) default 'ACTIVE'
);

#/////////////////////////////////CUSTOMERS//////////////////////////////////////////
create table if not exists customers
(
    id          bigint auto_increment primary key,
    guid        varchar(36),
    first_name  varchar(50)  not null,
    last_name   varchar(100) not null,
    status      varchar(25) default 'ACTIVE',
    unique (guid)
);

#/////////////////////////////////CARDS//////////////////////////////////////////
create table if not exists cards
(
    id                  bigint auto_increment primary key,
    id_customer         bigint,
    guid                varchar(36),
    created             timestamp    default CURRENT_TIMESTAMP,
    updated             timestamp    default CURRENT_TIMESTAMP,
    number_card         varchar(100),
    type_card           ENUM (1,2,3) default 1,
    discount_percentage int          default 3,
    status              varchar(25)  default 'ACTIVE',
    accumulation        bigint       default 0,

    unique (guid),
    foreign key (id_customer) references customers (id)
);

#/////////////////////////////////ORDERS//////////////////////////////////////////
create table if not exists orders
(
    id          bigint auto_increment primary key,
    guid        varchar(36),
    id_customer bigint not null,
    id_card     bigint not null,
    id_product  bigint not null

);

#/////////////////////////////////PRODUCTS//////////////////////////////////////////
create table if not exists products
(
  id            bigint auto_increment primary key,
  guid          varchar(36),
  id_parent     bigint not null,
  id_price      bigint,
  is_group      boolean default 0,
  name          varchar(256),
  type_product  varchar(36) default 'ТОВАР',
  status        varchar(25)  default 'ACTIVE'

);

#/////////////////////////////////PRICES//////////////////////////////////////////
create table if not exists prices (
    id              bigint auto_increment primary key,
    id_type_price   bigint not null,
    id_product      bigint not null,
    guid            varchar(36),
    price           double,
    status          varchar(25) default 'ACTIVE',

    foreign key (id_type_price) references type_prices(id),
    foreign key (id_product) references products(id)
);

create table if not exists type_prices(
    id      bigint auto_increment primary key,
    guid    varchar(36),
    name    varchar(256),
    status  varchar(25)  default 'ACTIVE'
);

#/////////////////////////////////ROLES//////////////////////////////////////////
create table if not exists roles
(
    id      bigint auto_increment primary key not null,
    guid    varchar(36),
    name    varchar(100),
    status  varchar(25)  default 'ACTIVE',
    unique (name)
);

#/////////////////////////////////USERS//////////////////////////////////////////
create table if not exists users
(
    id          bigint auto_increment primary key not null,
    guid        varchar(36),
    username    varchar(255),
    password    varchar(255),
    firstName   varchar(255),
    lastName    varchar(255),
    email       varchar(255),
    created     timestamp   default CURRENT_TIMESTAMP,
    updated     timestamp   default CURRENT_TIMESTAMP,
    status      varchar(25) default 'ACTIVE',

    unique (username)
);

#/////////////////////////////////USERS_ROLES//////////////////////////////////////////
create table if not exists users_roles
(
    user_id bigint,
    role_id bigint,

    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id),
    UNIQUE (user_id, role_id)
);
#/////////////////////////////////////INSERT//////////////////////////////////////

#// INSERT TO "PRODUCTS"
insert into products(id_parent, name) values (0,'Соки');
insert into products(id_parent, name) values (1, 'Манго');
insert into products(id_parent, name) values (1, 'Виноградный');
insert into products(id_parent, name) values (1, 'Яблочный');
insert into products(id_parent, name) values (0, 'Газировка');
insert into products(id_parent, name) values (5, 'Кола');
insert into products(id_parent, name) values (5, 'Спрайт');
insert into products(id_parent, name) values (5, 'Миниралка');
insert into products(id_parent, name) values (5, 'Лимонад');

#// INSERT TO "TYPE_PRICES"
insert into type_prices(name) values ('Розница');
insert into type_prices(name) values ('Оптовая');

#// INSERT TO "PRICES"
insert into prices(id_type_price, id_product, price) values (1, 2, 150.50);
insert into prices(id_type_price, id_product, price) values (1, 3, 190.20);
insert into prices(id_type_price, id_product, price) values (1, 4, 90.76);
insert into prices(id_type_price, id_product, price) values (1, 6, 100.10);
insert into prices(id_type_price, id_product, price) values (1, 7, 110.65);
insert into prices(id_type_price, id_product, price) values (1, 8, 60.30);
insert into prices(id_type_price, id_product, price) values (1, 9, 75.5);

insert into prices(id_type_price, id_product, price) values (2, 2, 100.50);
insert into prices(id_type_price, id_product, price) values (2, 3, 100.20);
insert into prices(id_type_price, id_product, price) values (2, 4, 10.76);
insert into prices(id_type_price, id_product, price) values (2, 6, 50.10);
insert into prices(id_type_price, id_product, price) values (2, 7, 10.65);
insert into prices(id_type_price, id_product, price) values (2, 8, 30.30);
insert into prices(id_type_price, id_product, price) values (2, 9, 25.5);

