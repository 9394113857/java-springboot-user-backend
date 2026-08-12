-- Purpose
-- This file defines the database schema.
-- V1__create_users_table.sql
--         ↓
-- Flyway
--         ↓
-- SQLite
--         ↓
-- users table

-- Later, this migration history becomes the basis for applying the schema to Supabase.

-- =========================================================
-- V1: Create users table
-- =========================================================

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

-- That's it for V1. Keep it simple.
-- Why these columns?
-- id
--     → unique user ID

-- username
--     → user's username

-- email
--     → user's email
--     → UNIQUE prevents duplicate emails
