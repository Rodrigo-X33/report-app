-- Script de creación de tablas para PostgreSQL

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    last_name_p VARCHAR(100) NOT NULL,
    last_name_m VARCHAR(100) NOT NULL,
    domicilio VARCHAR(255),
    tel VARCHAR(20),
    sanctions INTEGER DEFAULT 0,
    sanc_money INTEGER DEFAULT 0
);

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    date VARCHAR(20),
    author VARCHAR(100),
    category VARCHAR(100),
    edit VARCHAR(100),
    lang VARCHAR(50),
    pages VARCHAR(10),
    description TEXT,
    ejemplares VARCHAR(20),
    stock INTEGER DEFAULT 0,
    available INTEGER DEFAULT 0
);

CREATE TABLE lendings (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    book_id INTEGER NOT NULL REFERENCES books(id) ON DELETE CASCADE,
    date_out VARCHAR(20) NOT NULL,
    date_return VARCHAR(20)
);

-- Índices útiles
CREATE INDEX idx_lendings_user_id ON lendings(user_id);
CREATE INDEX idx_lendings_book_id ON lendings(book_id);
