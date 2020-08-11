DROP TABLE IF EXISTS customer CASCADE;

CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL
);

INSERT INTO customer (name) VALUES
('Nicollas Gabriel'),
('Thiago Cardoso');

DROP TABLE IF EXISTS card CASCADE;

CREATE TABLE card (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(12) NOT NULL UNIQUE,
    active BOOL NOT NULL DEFAULT FALSE,
    expired BOOL NOT NULL DEFAULT FALSE,
    customer_id INT NOT NULL,
    foreign key (customer_id) references customer(id)
);

INSERT INTO card (number, customer_id) VALUES
('123456789', 1),
('987654321', 2);

DROP TABLE IF EXISTS invoice;

CREATE TABLE invoice (
    id INT AUTO_INCREMENT PRIMARY KEY,
    payed_value DOUBLE NOT NULL,
    payed_in DATE NOT NULL,
    card_id INT NOT NULL,
    foreign key (card_id) references card(id)
);

DROP TABLE IF EXISTS payment;

CREATE TABLE payment (
     id INT AUTO_INCREMENT PRIMARY KEY,
     description VARCHAR(100) NOT NULL,
     value DOUBLE NOT NULL,
     card_id INT NOT NULL,
     foreign key (card_id) references card(id)
);

INSERT INTO payment (description, value, card_id) VALUES
('Compra de Cerveja', 300.56, 1),
('Compra de Café', 73.89, 2);