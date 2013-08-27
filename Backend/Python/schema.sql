drop table if exists entries;

create table entries (
  end_entry integer primary key,
  start_entry integer not null,
  device_name text not null
);