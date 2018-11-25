create table Student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table Views
(
   id integer not null,
   switch_board integer not null,
   item_number integer not null,
   menu_label varchar(255) not null,
   view_id varchar(3) not null,
   primary key(id)
);