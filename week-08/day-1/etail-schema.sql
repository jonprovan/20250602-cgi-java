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

-- DROP SCHEMA <name> will remove that database from the server
-- DROP SCHEMA etail;

-- CREATE TABLE <db name>.<table name> creates a new table in the noted DB with that name
-- you can also omit the DB name and just state the table name
-- if you do that, however, you have to select the proper database before this command will run
-- for string values, you can use either single or double quotes, in case your strings have single/double quotes in them, etc.
-- inside the parentheses, each column is described -- type, properties, etc.
CREATE TABLE `etail`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(32) NOT NULL,
  `last_name` VARCHAR(32) NOT NULL,
  `age` INT NOT NULL,
  `email` VARCHAR(32) NULL DEFAULT 'abc@123.com',
  PRIMARY KEY (`id`));

-- this table contains a foreign key pointing to our customer table
CREATE TABLE `etail`.`customer_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `detail` VARCHAR(1000) NOT NULL DEFAULT 'TBA',
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_id_from_customer_detail_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `customer_id_from_customer_detail`
    FOREIGN KEY (`customer_id`)
    REFERENCES `etail`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
  
# inserting records into a table
-- INSERT INTO <db name>.<table name>(column1, column2, etc.) VALUES(column1 value, column2 value, etc.);
INSERT INTO etail.customer(id, first_name, last_name, age, email) VALUES(6, 'Mark', 'Jeffries', 25, 'mark@gmail.com');
-- this works, because id auto-increments and email is allowed to be null and has a default value
INSERT INTO etail.customer(first_name, last_name, age) VALUES('Ellen', 'Blastowicz', 99);
-- this DOES NOT work, because last_name is not allowed to be null and does not have a default value
-- INSERT INTO etail.customer(first_name, age) VALUES('Leroy', 21);
INSERT INTO etail.customer(first_name, last_name, age, email) VALUES('Leroy', 'Jenkins', 40, 'leroy@wow.com');
INSERT INTO etail.customer(first_name, last_name, age, email) VALUES('Janice', 'Clink', 51, 'jc@yahoo.com'),
																	('Terry', 'Baker', 32, 'banjoking@aol.com'),
																	('Marjorie', 'Lazarus', 73, 'whatisemail@huh.com');

INSERT INTO etail.customer_detail(detail, customer_id) VALUES('Mark is astonishingly generic and has no standout characteristics.', 6);
INSERT INTO etail.customer_detail(detail, customer_id) VALUES('Ellen is like Betty White with gigantic biceps.', 7);
INSERT INTO etail.customer_detail(detail, customer_id) VALUES('Leroy started the raid too early and got everyone killed.', 8);

###############################################
#                                             #
#      STOP RUNNING THE SCRIPT HERE!!         #
#                                             #
###############################################

-- this gets all the records from the selected table
-- * refers to all columns
-- if you want to see only specific columns, you can put those in place of the star
SELECT * FROM customer;
SELECT first_name, email FROM customer;

SELECT * FROM customer_detail;



-- updating a record
-- UPDATE <table name> SET <prop1> = <new value>, <prop2> = <new value> WHERE <prop3> = <value>;
-- a WHERE clause says which subset of records you want to see
UPDATE customer SET id = 15 WHERE id = 8;
UPDATE customer SET first_name = 'Leeroy', age = 42 WHERE last_name = 'Jenkins' AND id = 15;



SELECT * FROM customer WHERE id = 12 AND last_name = 'Jenkins';
SELECT * FROM customer WHERE age = 99 OR last_name = 'Jenkins';

-- deleting a record
DELETE FROM customer WHERE id = 15;

DELETE FROM customer;
DELETE FROM customer WHERE id > 0;

DROP TABLE customer;
DROP TABLE customer_detail;

-- joining tables together to get results from both in one query
SELECT * FROM customer FULL JOIN customer_detail;
SELECT * FROM customer INNER JOIN customer_detail ON customer.id = customer_detail.customer_id;
SELECT * FROM customer LEFT JOIN customer_detail ON customer.id = customer_detail.customer_id;
SELECT * FROM customer_detail RIGHT JOIN customer ON customer.id = customer_detail.customer_id;
SELECT first_name, last_name, age, email, detail FROM customer JOIN customer_detail ON customer.id = customer_detail.customer_id;

# JOINS IN SQL
-- joins will combine the data from two tables into one result set
-- there are four main types of join we'll use, and one of them is not particularly useful
-- one in particular gets a lot of use

-- FULL (OUTER) JOIN = returns every record on the left matched with every record on the right (e.g. 3 left and 3 right would return 9 results rows)
-- (INNER) JOIN = returns all the matches between the two tables, based on whatever ON criteria you give it
-- LEFT JOIN = returns an INNER JOIN plus all the unmatching records from the left table (the one to the left of the keywords)
-- RIGHT JOIN = returns an INNER JOIN plus all the unmatching records from the right table (the one to the right of the keywords)


# THE WHERE CLAUSE
-- you can trigger off specific values and whether they are = < > <= >= other values, etc.
SELECT * FROM customer;
SELECT * FROM customer WHERE age = 25;
SELECT * FROM customer WHERE age > 40;
SELECT * FROM customer WHERE age <= 51;
SELECT * FROM customer WHERE last_name = 'Clink';

-- you can combine conditions as well
SELECT * FROM customer WHERE age = 51 AND first_name = 'Janice';
SELECT * FROM customer WHERE age = 25 OR first_name = 'Janice';
SELECT * FROM customer WHERE age = 25 OR first_name = 'Janice' OR id = 11;
SELECT * FROM customer WHERE age != 25;
SELECT * FROM customer WHERE age <> 25; -- this also works for !=
SELECT * FROM customer WHERE !(age = 25 OR first_name = 'Janice');
SELECT * FROM customer WHERE age BETWEEN 40 AND 60;

-- you can also use LIKE to search for patterns in the data
-- the % wildcard means 'zero or more characters'
SELECT * FROM customer WHERE last_name LIKE 'J%';
SELECT * FROM customer WHERE last_name LIKE 'J%s';
SELECT * FROM customer WHERE last_name LIKE 'J%ns';
SELECT * FROM customer WHERE last_name LIKE '%a%a%';

-- the _ wildcard means 'one and exactly one character'
SELECT * FROM customer WHERE first_name LIKE 'M_'; -- this returns nothing, because there are no two-letter first names
SELECT * FROM customer WHERE first_name LIKE 'M___'; -- but this returns Mark
SELECT * FROM customer WHERE first_name LIKE '_ani%';

-- we also have some other filtration options for results
SELECT * FROM customer LIMIT 3;
SELECT * FROM customer ORDER BY age ASC;
SELECT * FROM customer ORDER BY age DESC;
SELECT * FROM customer ORDER BY email ASC;
SELECT * FROM customer ORDER BY email DESC;

-- we also have some functions we can run on the data
SELECT MIN(age) AS minimum_customer_age, MAX(age) maximum_customer_age FROM customer;
SELECT SUM(id) AS total_of_all_ids FROM customer;
SELECT COUNT(*) AS number_of_customers FROM customer;

















