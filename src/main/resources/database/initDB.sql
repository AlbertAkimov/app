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

#/////////////////////////////////BARCODES///////////////////////////////////////

create table if not exists barcodes(
    id              bigint auto_increment primary key,
    guid            varchar(36),
    barcode         varchar(256) not null,
    type_barcode    varchar(10) default 'EAN13',
    status          varchar(25) default 'ACTIVE',
    unique (guid)

);

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
    number_card         varchar(100),
    type_card           ENUM (1,2,3) default 1,
    discount_percent    int          default 3,
    status              varchar(25)  default 'ACTIVE',
    accumulation        bigint       default 0,

    unique (guid),
    foreign key (id_customer) references customers (id)
);

#/////////////////////////////////ORDERS//////////////////////////////////////////
create table if not exists orders #todo доделать таблицу
(
    id          bigint auto_increment primary key,
    guid        varchar(36),
    id_customer bigint not null,
    id_card     bigint,
    id_product  bigint not null

);

#/////////////////////////////////PRODUCTS//////////////////////////////////////////
create table if not exists products
(
  id            bigint auto_increment primary key,
  guid          varchar(36),
  id_parent     bigint not null,
  id_unit       bigint not null,
  id_barcode    bigint,
  is_group      boolean default 0,
  level_group   int default 1 not null,
  name          varchar(256),
  type_product  varchar(36) default 'ТОВАР',
  status        varchar(25)  default 'ACTIVE',

    foreign key (id_unit) references units(id),
    foreign key (id_barcode) references barcodes(id),
    unique (guid)

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
    id          bigint auto_increment primary key,
    guid        varchar(36),
    name        varchar(256),
    status      varchar(25)  default 'ACTIVE'
);

#/////////////////////////////////ROLES//////////////////////////////////////////
create table if not exists roles
(
    id          bigint auto_increment primary key not null,
    guid        varchar(36),
    name        varchar(100),
    status      varchar(25)  default 'ACTIVE',
    unique (name)
);

#/////////////////////////////////USERS//////////////////////////////////////////
create table if not exists users
(
    id                  bigint auto_increment primary key not null,
    guid                varchar(36),
    username            varchar(255),
    password            varchar(255),
    firstName           varchar(255),
    lastName            varchar(255),
    email               varchar(255),
    status              varchar(25) default 'ACTIVE',
    password_confirm    varchar(255),
    phone varchar(25),

    unique (username)
);

#/////////////////////////////////USERS_ROLES//////////////////////////////////////////
create table if not exists users_roles
(
    id              bigint auto_increment primary key not null,
    guid            varchar(36),
    user_id         bigint not null ,
    role_id         bigint not null ,
    permission_id   bigint not null,
    status          varchar(25) default 'ACTIVE',

    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id),
    foreign key (permission_id) references permissions (id),
    UNIQUE (user_id, role_id, permission_id)
);

#/////////////////////////////////PERMISSIONS//////////////////////////////////////////

create table if not exists permissions
(
    id              bigint auto_increment primary key not null,
    guid            varchar(36),
    status          varchar(25) default 'ACTIVE',
    name            varchar(255) not null
);

#/////////////////////////////////CHAT MESSAGE//////////////////////////////////////////

create table if not exists chat_message(

    id              bigint auto_increment primary key  not null,
    guid            varchar(36),
    status          varchar(25) default 'ACTIVE',
    chat_id bigint not null,
    sender_id bigint not null,
    recipient_id bigint not null,
    sender_name varchar(512) not null ,
    recipient_name varchar(512) not null,
    content mediumtext not null,
    timestamp timestamp not null,
    message_status enum('RECEIVED', 'DELIVERED')

);

create table if not exists chat_room
(
    id         bigint auto_increment primary key not null,
    guid       varchar(36),
    status     varchar(25) default 'ACTIVE',
    chat_id bigint not null,
    sender_id bigint not null,
    recipient_id bigint not null
);

#/////////////////////////////////AUDIT//////////////////////////////////////////

create table if not exists revision_info
(
    revision_id   bigint auto_increment primary key not null ,
    rev_timestamp timestamp  not null ,
    user        varchar(512) not null
);