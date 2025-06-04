create table if not exists department
(
    id                 uuid primary key DEFAULT gen_random_uuid(),
    company_id text,
    name               text not null,
    created_at         timestamp,
    updated_at         timestamp,
    deleted_at      timestamp,
    version            int
);
