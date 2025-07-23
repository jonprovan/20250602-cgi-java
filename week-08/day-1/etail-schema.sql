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

CREATE TABLE `etail`.`online_order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_date` DATE NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_id_from_order_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `customer_id_from_order`
    FOREIGN KEY (`customer_id`)
    REFERENCES `etail`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);
    
CREATE TABLE `etail`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(64) NOT NULL,
  `price` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`id`));

-- for Spring Boot purposes, you can call your join table whatever you like!
-- we'll specify the name of the join table in our OnlineOrder class, so it can be whatever
-- HOWEVER, some frameworks, like NestJS with TypeORM, require specific naming conventions for join tables
-- <controlling table name>_<plural of controlled table name>_<controlled table name>
-- so, we're naming our table accordingly -- a good habit to get into
-- which side is the "controlling" side is up to us, as you'll see in Spring  
CREATE TABLE `etail`.`online_order_items_item` (
  `online_order_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`online_order_id`, `item_id`),
  INDEX `item_id_from_online_order_items_item_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `online_order_id_from_online_order_items_item`
    FOREIGN KEY (`online_order_id`)
    REFERENCES `etail`.`online_order` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `item_id_from_online_order_items_item`
    FOREIGN KEY (`item_id`)
    REFERENCES `etail`.`item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
-- ALTER TABLE will change an existing table however you specify
-- you DO NOT need to delete the table and recreate it

-- ALTER TABLE `etail`.`order` 
-- CHANGE COLUMN `date` `order_date` DATE NOT NULL ;
  
# inserting records into a table
-- INSERT INTO <db name>.<table name>(column1, column2, etc.) VALUES(column1 value, column2 value, etc.);
INSERT INTO etail.customer(id, first_name, last_name, age, email) VALUES(1, 'Mark', 'Jeffries', 25, 'mark@gmail.com');
-- this works, because id auto-increments and email is allowed to be null and has a default value
INSERT INTO etail.customer(first_name, last_name, age) VALUES('Ellen', 'Blastowicz', 99);
-- this DOES NOT work, because last_name is not allowed to be null and does not have a default value
-- INSERT INTO etail.customer(first_name, age) VALUES('Leroy', 21);
INSERT INTO etail.customer(first_name, last_name, age, email) VALUES('Leroy', 'Jenkins', 40, 'leroy@wow.com');
INSERT INTO etail.customer(first_name, last_name, age, email) VALUES('Janice', 'Clink', 51, 'jc@yahoo.com'),
																	('Terry', 'Baker', 32, 'banjoking@aol.com'),
																	('Marjorie', 'Lazarus', 73, 'whatisemail@huh.com');

INSERT INTO etail.customer_detail(detail, customer_id) VALUES('Mark is astonishingly generic and has no standout characteristics.', 1);
INSERT INTO etail.customer_detail(detail, customer_id) VALUES('Ellen is like Betty White with gigantic biceps.', 2);
INSERT INTO etail.customer_detail(detail, customer_id) VALUES('Leroy started the raid too early and got everyone killed.', 3);

INSERT INTO etail.online_order(order_date, customer_id) VALUES('2024-12-21', 1),
															  ('2025-02-14', 1),
                                                              ('2023-07-09', 2),
                                                              ('2025-05-15', 2),
                                                              ('2024-11-01', 3),
                                                              ('2025-03-11', 3),
                                                              ('2022-06-30', 4),
                                                              ('2023-01-31', 4),
                                                              ('2024-02-19', 5),
                                                              ('2025-07-23', 6);

INSERT INTO etail.item (item_name, price) VALUES ('Warm Knit Beanie', 19.99);
INSERT INTO etail.item (item_name, price) VALUES ('USB Wall Charger', 19.99);
INSERT INTO etail.item (item_name, price) VALUES ('Avocado Lime Dressing', 4.29);
INSERT INTO etail.item (item_name, price) VALUES ('Tabletop Fire Pit', 79.99);
INSERT INTO etail.item (item_name, price) VALUES ('Chocolate Mint Cookies', 2.29);
INSERT INTO etail.item (item_name, price) VALUES ('Beef Enchilada Casserole', 8.99);
INSERT INTO etail.item (item_name, price) VALUES ('Biodegradable Dog Waste Bags', 14.99);
INSERT INTO etail.item (item_name, price) VALUES ('Zucchini', 0.79);
INSERT INTO etail.item (item_name, price) VALUES ('Insulated Lunch Bag', 24.99);
INSERT INTO etail.item (item_name, price) VALUES ('Homestyle Chicken Noodle Soup', 2.99);
INSERT INTO etail.item (item_name, price) VALUES ('Silicone Baking Mat Set', 24.99);
INSERT INTO etail.item (item_name, price) VALUES ('Coconut Lime Rice', 2.99);
INSERT INTO etail.item (item_name, price) VALUES ('Inflatable Paddle Board', 349.99);
INSERT INTO etail.item (item_name, price) VALUES ('Smashed Avocado with Lime', 2.49);
INSERT INTO etail.item (item_name, price) VALUES ('Teriyaki Chicken Skewers', 8.99);
INSERT INTO etail.item (item_name, price) VALUES ('Classic Black Dress', 79.99);
INSERT INTO etail.item (item_name, price) VALUES ('LED Strip Lights', 19.99);
INSERT INTO etail.item (item_name, price) VALUES ('Nutty Trail Mix', 4.29);
INSERT INTO etail.item (item_name, price) VALUES ('Zesty Garlic Marinade', 4.49);
INSERT INTO etail.item (item_name, price) VALUES ('Kids'' Gardening Kit', 24.99);
INSERT INTO etail.item (item_name, price) VALUES ('Vegan chocolate chip cookies', 4.79);
INSERT INTO etail.item (item_name, price) VALUES ('Reversible Comforter Set', 89.99);
INSERT INTO etail.item (item_name, price) VALUES ('Garlic Parmesan Wings', 8.99);
INSERT INTO etail.item (item_name, price) VALUES ('Travel Sewing Kit', 12.99);
INSERT INTO etail.item (item_name, price) VALUES ('Cordless Water Flosser', 49.99);
INSERT INTO etail.item (item_name, price) VALUES ('Maple Oatmeal', 2.99);
INSERT INTO etail.item (item_name, price) VALUES ('Asian Salad Mix', 3.99);
INSERT INTO etail.item (item_name, price) VALUES ('Fleece Hoodie', 39.99);
INSERT INTO etail.item (item_name, price) VALUES ('Magnetic Chess Set', 19.99);
INSERT INTO etail.item (item_name, price) VALUES ('Crispy Chickpeas', 2.99);
INSERT INTO etail.item (item_name, price) VALUES ('Electric Food Steamer', 59.99);
INSERT INTO etail.item (item_name, price) VALUES ('Pet Safety Harness', 24.99);
INSERT INTO etail.item (item_name, price) VALUES ('Ramen Noodles', 0.99);
INSERT INTO etail.item (item_name, price) VALUES ('Hibiscus Tea Bags', 3.79);
INSERT INTO etail.item (item_name, price) VALUES ('Teriyaki Sauce', 2.99);
INSERT INTO etail.item (item_name, price) VALUES ('Cinnamon Apple Sauce', 2.49);
INSERT INTO etail.item (item_name, price) VALUES ('Applewood Smoked Bacon', 6.99);
INSERT INTO etail.item (item_name, price) VALUES ('Organic Cereal Bars', 4.29);
INSERT INTO etail.item (item_name, price) VALUES ('Vegan Caesar Dressing', 3.99);
INSERT INTO etail.item (item_name, price) VALUES ('Graphic Print Leggings', 29.99);
INSERT INTO etail.item (item_name, price) VALUES ('Pet Leash', 15.99);
INSERT INTO etail.item (item_name, price) VALUES ('Mediterranean Chickpea Salad', 5.99);
INSERT INTO etail.item (item_name, price) VALUES ('Roasted Garlic Mashed Potatoes', 3.99);
INSERT INTO etail.item (item_name, price) VALUES ('Children''s Gardening Set', 19.99);
INSERT INTO etail.item (item_name, price) VALUES ('Pet Grooming Gloves', 9.99);
INSERT INTO etail.item (item_name, price) VALUES ('Lemon Dill Salmon', 9.99);
INSERT INTO etail.item (item_name, price) VALUES ('Rice Cakes', 2.29);
INSERT INTO etail.item (item_name, price) VALUES ('Granola Bars', 4.99);
INSERT INTO etail.item (item_name, price) VALUES ('Tailored Dress Pants', 79.99);
INSERT INTO etail.item (item_name, price) VALUES ('Pet Travel Carrier', 39.99);

INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (4, 13);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (10, 27);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (6, 42);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (10, 43);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (1, 38);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (10, 36);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (6, 8);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (9, 20);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (4, 39);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (9, 15);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (5, 15);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (8, 9);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (5, 25);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (5, 32);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (6, 32);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (6, 43);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (4, 48);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (1, 24);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (6, 19);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (9, 21);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (3, 42);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (8, 29);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (3, 35);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (10, 25);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (7, 14);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (3, 27);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (9, 37);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (2, 2);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (1, 25);
INSERT INTO etail.online_order_items_item (online_order_id, item_id) VALUES (7, 5);

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


# Checking our database and practicing joins
SELECT * FROM customer;

SELECT * FROM customer JOIN customer_detail ON customer.id = customer_detail.customer_id;

SELECT customer.email, customer_detail.detail FROM customer LEFT JOIN customer_detail ON customer.id = customer_detail.customer_id;

-- if you count a specific field, it'll return the number of those that ARE NOT NULL!
SELECT count(email), count(detail) FROM customer LEFT JOIN customer_detail ON customer.id = customer_detail.customer_id;

SELECT online_order.id, customer.first_name, customer.last_name, customer.email, online_order.order_date 
	FROM customer JOIN online_order ON customer.id = online_order.customer_id;
 
-- to get our order-to-item records, we have to join twice
-- once between the orders and the join table, once between the join table and the items
SELECT * FROM online_order
		 JOIN online_order_items_item ON online_order.id = online_order_items_item.online_order_id
         JOIN item ON online_order_items_item.item_id = item.id;

-- GROUP BY can be useful for creating groups of records based on a certain property/column value
-- you can then run aggregate actions on those groups, like COUNT()...
SELECT online_order.id AS order_id, COUNT(*) AS num_items FROM online_order
		 JOIN online_order_items_item ON online_order.id = online_order_items_item.online_order_id
         JOIN item ON online_order_items_item.item_id = item.id
         GROUP BY online_order.id;

-- and SUM()
SELECT online_order.id AS order_id, SUM(price) AS total_price FROM online_order
		 JOIN online_order_items_item ON online_order.id = online_order_items_item.online_order_id
         JOIN item ON online_order_items_item.item_id = item.id
         GROUP BY online_order.id;