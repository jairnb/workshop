create table if not exists employee
(
    id                  uuid primary key DEFAULT gen_random_uuid(),
    first_name          text not null,
    middle_name         text,
    last_name           text,
    phone_number        bigint,
    email               text,
    ssn                 text,
    birthdate           date,
    hire_date           date,
    status              boolean,
    company_id          text,
    created_at          timestamp,
    updated_at          timestamp,
    deleted_at          timestamp,
    version             int
);


create table if not exists address
(
    id              uuid primary key DEFAULT gen_random_uuid(),
    employee         uuid,
    street_address  text,
    street_address2 text,
    street_address3 text,
    city            text,
    state           text,
    zip             text,
    country         text,
    county          text,
    created_at      timestamp,
    updated_at      timestamp,
    deleted_at      timestamp,
    FOREIGN KEY (employee) references employee (id)
);