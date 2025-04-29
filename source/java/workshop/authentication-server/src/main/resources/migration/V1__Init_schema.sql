create table if not exists users
(
    id                 uuid primary key DEFAULT gen_random_uuid(),
    company_identifier text,
    phone_number       bigint,
    name               text not null,
    created_at         timestamp,
    updated_at         timestamp,
    deleted_at      timestamp,
    version            int
);

