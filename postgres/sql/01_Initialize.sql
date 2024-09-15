-- ユーザーとスキーマの作成
CREATE USER library_app WITH PASSWORD '456789' CREATEDB;
CREATE SCHEMA library_app_schema AUTHORIZATION library_app;
SET ROLE library_app;

-- テーブル作成
CREATE TABLE IF NOT EXISTS library_app_schema.author (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS library_app_schema.book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(1024) NOT NULL
);

CREATE TABLE IF NOT EXISTS library_app_schema.work (
    book_id INTEGER NOT NULL REFERENCES library_app_schema.book (id) ON DELETE CASCADE ON UPDATE CASCADE,
    author_id INTEGER NOT NULL REFERENCES library_app_schema.author (id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (book_id, author_id)
);