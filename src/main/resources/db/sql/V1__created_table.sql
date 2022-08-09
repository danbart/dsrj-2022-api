CREATE TABLE IF NOT EXISTS directory_office
(
    directory_id     BIGINT NOT NULL AUTO_INCREMENT,
    directory_name   varchar(250) not null default 'S/D',
    address_line     varchar(250) not null default 'S/D',
    country          varchar(100) not null default 'S/D',
    state            varchar(100) not null default 'S/D',
    city             varchar(100) not null default 'S/D',
    zone             varchar(100) not null default 'S/D',
    phone            bigint not null default 0,
    phone_2          bigint not null default 0,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (directory_id)
)