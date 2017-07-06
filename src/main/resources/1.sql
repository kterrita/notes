drop table if exists users;
create table users
(
  user_id int not null auto_increment
    primary key,
  password varchar(150) null,
  username varchar(30) not null
)
;

