create table if not exists employee (
    id   uuid primary key DEFAULT gen_random_uuid(),
    name text not null
);