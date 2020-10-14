DROP TABLE `car`;

CREATE TABLE car (
	id bigint generated by default as identity, 
	colour varchar(255), 
	contact_number varchar(255), 
	description varchar(255), 
	email varchar(255), 
	engine_size float not null, 
	gearbox varchar(255), 
	make varchar(255), 
	model varchar(255), 
	post_code_last_seen varchar(255), 
	year integer not null, 
	primary key (id))