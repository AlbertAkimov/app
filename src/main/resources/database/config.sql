create table sidebar(
    id              bigint auto_increment primary key,
    id_parent       bigint,
    guid            varchar(36),
    id_sidebar      varchar(36),
    value           varchar(128),
    icon            varchar(256),
    is_group        boolean default false,
    created         timestamp   default CURRENT_TIMESTAMP,
    updated         timestamp   default CURRENT_TIMESTAMP,
    created_by      varchar(255),
    updated_by      varchar(255)
);