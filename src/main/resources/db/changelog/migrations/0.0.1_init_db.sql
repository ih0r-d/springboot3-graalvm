-- liquibase formatted sql
-- changeset ihor.didyk:1701008172000-1
create table if not exists companies
(
    id         bigserial primary key not null,
    name text                  not null,
    industry  text                  not null,
    profession      text                  not null
);