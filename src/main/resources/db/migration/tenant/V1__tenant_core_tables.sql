CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS employee (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    email VARCHAR(120)
);
CREATE TABLE IF NOT EXISTS product (
    id BIGSERIAL PRIMARY KEY,
    sku VARCHAR(50),
    name VARCHAR(120),
    stock_qty INT,
    price NUMERIC(12,2)
);
CREATE TABLE IF NOT EXISTS invoice (
    id BIGSERIAL PRIMARY KEY,
    number VARCHAR(50),
    total_amount NUMERIC(12,2),
    issued_on DATE,
    status VARCHAR(40)
);
CREATE TABLE IF NOT EXISTS payment (
    id BIGSERIAL PRIMARY KEY,
    invoice_id BIGINT,
    amount NUMERIC(12,2),
    paid_on DATE
);
