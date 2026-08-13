-- =========================================================
-- V1: Create users table
-- =========================================================
-- Purpose:
-- Creates the users table for the application.
--
-- Database:
-- PostgreSQL / Supabase
--
-- Flyway:
-- This migration is executed automatically on application startup.
-- =========================================================


CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);


-- =========================================================
-- Column explanation
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