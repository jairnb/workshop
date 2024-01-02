create table if not exists company (
    id   uuid primary key DEFAULT gen_random_uuid(),
    name text not null
);