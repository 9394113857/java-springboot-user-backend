-- =========================================================
-- V1: CREATE LOCAL SQLITE USERS TABLE
-- =========================================================

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);