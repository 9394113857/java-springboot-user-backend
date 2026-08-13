-- =========================================================
-- 🛫 V1: CREATE USERS TABLE
-- =========================================================
-- Purpose:
-- Creates the users table for the application.
--
-- Database:
-- PostgreSQL / Supabase
--
-- Flyway:
-- This migration is executed automatically by Flyway.
-- =========================================================


CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);


-- =========================================================
-- 📋 COLUMN EXPLANATION
-- =========================================================
-- id
--     → Unique user ID
--     → BIGSERIAL automatically generates sequential IDs
--
-- username
--     → User's username
--
-- email
--     → User's email address
--     → UNIQUE prevents duplicate email addresses
-- =========================================================