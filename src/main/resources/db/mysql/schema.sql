Create database if not exists filmhouse;

ALTER DATABASE filmhouse
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

use filmhouse;  

create table if not exists movie(
	id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	movieName varchar(30),
    releaseDate date,
    madeCon varchar(20)
    genre varchar(20),
    runtime int,
	director varchar(40),
    production varchar(30)
    
);

create table if not exists reviewForum(
	id int(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	title varchar(50),
	writerName varchar(50),
	reg_date timestamp,
	content text
);






