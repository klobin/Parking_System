/********* HSQL db **********/

create table parking_master (floor_no int,bikes int,cars int,hv int);
create table car_master (floor_id int,parking_bay varchar(20),parked varchar(20),car_reg_no varchar(20));
create table bike_master (floor_id int,parking_bay varchar(20),parked varchar(20),bike_reg_no varchar(20));
create table hv_master (floor_id int,parking_bay varchar(20),parked varchar(20),hv_reg_no varchar(20));


insert into parking_master values(0,0,0,0);

select * from parking_master;

select * from car_master;
select * from bike_master;
select * from hv_master;
