create table if not exists company
(
    id           uuid primary key DEFAULT gen_random_uuid(),
    company_id   text,
    phone_number bigint,
    name         text not null,
    created_at   timestamp,
    updated_at   timestamp,
    version      int
);


create table if not exists address
(
--     id              uuid primary key DEFAULT gen_random_uuid(),
    company         uuid references company(id),
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
    version         int
);