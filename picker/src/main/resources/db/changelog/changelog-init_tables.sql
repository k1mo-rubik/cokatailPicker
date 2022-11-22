CREATE TABLE customers
(
    id       serial PRIMARY KEY NOT NULL,
    nickname VARCHAR(100)    NOT NULL
);

CREATE table types
(
    id   INT PRIMARY KEY NOT NULL,
    name VARCHAR(100)    NOT NULL
);

CREATE TABLE cocktails
(
    id      INT PRIMARY KEY NOT NULL,
    name    VARCHAR(100)    NOT NULL,
    type    int             NOT NULL,
    picture VARCHAR(255)    NOT NULL,
    foreign key (type) references types (id)
);

create table ingredients
(
    id   INT PRIMARY KEY NOT NULL,
    name VARCHAR(100)    NOT NULL
);

CREATE TABLE cocktails_ingredients
(
    cocktail_id   INT NOT NULL,
    ingredient_id INT NOT NULL,
    PRIMARY KEY (cocktail_id, ingredient_id),
    FOREIGN KEY (cocktail_id) REFERENCES cocktails (id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredients (id)
);



CREATE TABLE customers_cocktails
(
    customer_id INT NOT NULL,
    cocktail_id INT NOT NULL,
    PRIMARY KEY (customer_id, cocktail_id),
    FOREIGN KEY (customer_id) REFERENCES customers (id),
    FOREIGN KEY (cocktail_id) REFERENCES cocktails (id)
);
