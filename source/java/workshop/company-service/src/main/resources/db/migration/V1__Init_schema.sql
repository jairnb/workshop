create schema if not exists fernandes;

create table if not exists fernandes.company
(
    id                 uuid primary key DEFAULT gen_random_uuid(), --serial primary key, --,
    company_identifier text,
    phone_number       bigint,
    name               text not null,
    created_at         timestamp,
    updated_at         timestamp,
    version            int
);


create table if not exists fernandes.address
(
    id              uuid primary key DEFAULT gen_random_uuid(),
    company         uuid,
    street_address  text,
    street_address2 text,
    street_address3 text,
    city            text,
    state           text,
    zip             text,
    country         text,
    county          text,
    latitude        decimal,
    longitude       decimal,
    created_at      timestamp,
    updated_at      timestamp,
    FOREIGN KEY (company) references company (id)
);