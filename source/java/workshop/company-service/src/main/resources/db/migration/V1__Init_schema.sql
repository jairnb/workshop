create table if not exists company
(
    id           uuid primary key DEFAULT gen_random_uuid(),
    company_id   text,
    phone_number bigint,
    name         text not null,
    created_at   timestamp,
    updated_at   timestamp
);


create table if not exists address
(
    id               serial primary key,
    company_id       uuid references company (id),
    street_address   text,
    street_address_2 text,
    street_address_3 text,
    city             text,
    state            text,
    zip              text,
    country          text,
    county           text,
    latitude         decimal,
    longitude        decimal,
    created_at       timestamp,
    updated_at       timestamp
);