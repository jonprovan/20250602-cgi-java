# this is one kind of comment in SQL
-- this is another kind of comment

# SQL IN GENERAL
-- this file includes SQL statements
-- you can run them individually or in a group
-- it's not a compiled file, in that each statement lives on its own
-- SQL = Structured Query Language
-- queries include ANYTHING we want to do with our database
-- getting some records, creating a new record, updating a record, deleting a record, etc.
-- you can also create databases, create tables, alter the structure of things, etc.

# E-TAIL DATABASE
-- customers
-- orders/returns
-- items
-- personal details

-- customer-to-order one-to-many
-- order-to-item many-to-many
-- customer-to-customer_detail one-to-one

-- CREATE SCHEMA <name> makes a new database on the server with that name
CREATE SCHEMA `etail`;

CREATE TABLE `etail`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(32) NOT NULL,
  `last_name` VARCHAR(32) NOT NULL,
  `age` INT NOT NULL,
  `email` VARCHAR(32) NULL DEFAULT 'abc@123.com',
  PRIMARY KEY (`id`));








