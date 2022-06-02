CREATE DATABASE IF NOT EXISTS dbpolimorphism;
USE dbpolimorphism;

CREATE TABLE IF NOT EXISTS tblProducts(
product_id int NOT NULL auto_increment primary key,
product_name varchar(50),
product_price double NOT NULL,
product_manufacture date NOT NULL,
product_customs_fee double
)auto_increment = 1;


