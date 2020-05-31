ALTER TABLE users
    AUTO_INCREMENT = 0;
ALTER TABLE cards
    AUTO_INCREMENT = 0;
ALTER TABLE customers
    AUTO_INCREMENT = 0;
ALTER TABLE users_roles
    AUTO_INCREMENT = 0;

#/////////////////////////////////COMMONS//////////////////////////////////////////
create table if not exists customers
(
    id         bigint auto_increment primary key,
    guid    varchar(36),
    first_name varchar(50)  not null,
    last_name  varchar(100) not null,
    status     varchar(25) default 'ACTIVE',
    unique (guid)
);

create table if not exists cards
(
    id                  bigint auto_increment primary key,
    id_customer         bigint,
    guid             varchar(36),
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

create table if not exists orders
(
    id          bigint auto_increment primary key,
    guid     varchar(36),
    id_customer bigint,
    id_card     bigint,
    id_product  bigint not null

);

create table if not exists products
(
  id bigint auto_increment primary key,
  guid varchar(36),
  id_parent bigint not null,
  is_group boolean default 0,
  id_category bigint not null,
  name varchar(256),

  foreign key (id_category) references product_categories(id)
);

create table if not exists product_categories(

    id bigint auto_increment primary key,
    guid varchar(36),
    id_parent bigint,
    name varchar(256),
    is_group boolean default 0
);

#/////////////////////////////////USER//////////////////////////////////////////
create table if not exists roles
(
    id      bigint auto_increment primary key not null,
    guid varchar(36),
    name    varchar(100),
    unique (name)
);

create table if not exists users
(
    id        bigint auto_increment primary key not null,
    guid   varchar(36),
    username  varchar(255),
    password  varchar(255),
    firstName varchar(255),
    lastName  varchar(255),
    email     varchar(255),
    created   timestamp   default CURRENT_TIMESTAMP,
    updated   timestamp   default CURRENT_TIMESTAMP,
    status    varchar(25) default 'ACTIVE',
    unique (username)
);

create table if not exists users_roles
(
    user_id bigint,
    role_id bigint,

    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id),
    UNIQUE (user_id, role_id)
);
#/////////////////////////////////////INSERT//////////////////////////////////////
insert into product_categories(id_parent, name) values (0, 'Товар');

insert into products(id_parent, id_category, name) values (0, 1, 'Соки');
insert into products(id_parent, id_category, name) values (1, 1, 'Манго');
insert into products(id_parent, id_category, name) values (1, 1, 'Виноградный');
insert into products(id_parent, id_category, name) values (1, 1, 'Яблочный');
insert into products(id_parent, id_category, name) values (0, 1, 'Газировка');
insert into products(id_parent, id_category, name) values (5, 1, 'Кола');
insert into products(id_parent, id_category, name) values (5, 1, 'Спрайт');
insert into products(id_parent, id_category, name) values (5, 1, 'Миниралка');
insert into products(id_parent, id_category, name) values (5, 1, 'Лимонад');