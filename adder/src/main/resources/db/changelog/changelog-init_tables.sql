create table if not exists room
(
    id   uuid primary key,
    name text not null unique
);

CREATE table if not exists customer
(
    id      uuid primary key,
    name    text,
    chat_id  bigint not null,
    room_id uuid,
    role   text,
    foreign key (room_id) references room (id)
);

create table if not exists cocktail
(
    id      uuid primary key,
    name    text not null,
    inStock boolean default true
);

create table if not exists queue
(
    id          uuid primary key,
    customer_id uuid not null,
    cocktail_id uuid not null,
    foreign key (customer_id) references customer (id),
    foreign key (cocktail_id) references cocktail (id)
);

create table if not exists cocktail_room (
    id          uuid primary key,
    cocktail_id uuid not null,
    room_id     uuid not null,
    foreign key (cocktail_id) references cocktail (id),
    foreign key (room_id) references room (id)
);