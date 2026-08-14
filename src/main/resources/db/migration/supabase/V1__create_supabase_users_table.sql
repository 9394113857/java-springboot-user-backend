-- =========================================================
-- V1: CREATE SUPABASE USERS TABLE
-- =========================================================

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);