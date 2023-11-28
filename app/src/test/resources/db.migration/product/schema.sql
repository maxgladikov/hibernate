CREATE TABLE IF NOT EXISTS products (
    maker CHAR NOT NULL,
    model INT NOT NULL,
    type VARCHAR(20) NOT NULL,
    INDEX(model),
    PRIMARY KEY(model)
);

CREATE TABLE IF NOT EXISTS pc (
    product_model INT NOT NULL,
    speed FLOAT NOT NULL,
    ram INT NOT NULL,
    hd INT NOT NULL,
    price  INT NOT NULL,
    INDEX(product_model),
    PRIMARY KEY(product_model),
    FOREIGN KEY(product_model) 
    REFERENCES products(model)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS laptops (
    product_model INT,
    speed FLOAT,
    ram INT,
    hd INT,
    screeen FLOAT NOT NULL,
    price  INT,
    INDEX(product_model),
    PRIMARY KEY(product_model),
    FOREIGN KEY(product_model) 
    REFERENCES products(model)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS printers (
    product_model INT NOT NULL,
    color BOOLEAN NOT NULL,
    type VARCHAR(20) NOT NULL,
    price INT NOT NULL,
    INDEX(product_model),
    PRIMARY KEY(product_model),
    FOREIGN KEY(product_model)
    REFERENCES products(model)
    ON DELETE CASCADE
);





