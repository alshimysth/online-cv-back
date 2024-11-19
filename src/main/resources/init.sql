-- Create the database
CREATE DATABASE online_cv;

-- Connect to the database (use \c online_cv in PostgreSQL CLI or connect separately in a GUI like pgAdmin)
\c online_cv

-- Table: User
CREATE TABLE "User" (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20),
    address VARCHAR(255),
    linkedin VARCHAR(255),
    github VARCHAR(255),
    summary TEXT,
    profile_picture VARCHAR(255)
);

-- Table: Education
CREATE TABLE Education (
    id SERIAL PRIMARY KEY,
    institution_name VARCHAR(100) NOT NULL,
    degree VARCHAR(100),
    field_of_study VARCHAR(100),
    start_date DATE,
    end_date DATE,
    description TEXT
);

-- Table: Experience
CREATE TABLE Experience (
    id SERIAL PRIMARY KEY,
    job_title VARCHAR(100) NOT NULL,
    company_name VARCHAR(100),
    start_date DATE,
    end_date DATE,
    location VARCHAR(100),
    description TEXT
);

-- Table: Skills
CREATE TABLE Skills (
    id SERIAL PRIMARY KEY,
    skill_name VARCHAR(50) NOT NULL,
    category VARCHAR(50),
    proficiency_level VARCHAR(15) CHECK (proficiency_level IN ('Beginner', 'Intermediate', 'Advanced'))
);

-- Table: Projects
CREATE TABLE Projects (
    id SERIAL PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    description TEXT,
    technologies_used TEXT,
    start_date DATE,
    end_date DATE,
    link VARCHAR(255)
);

-- Table: Certifications
CREATE TABLE Certifications (
    id SERIAL PRIMARY KEY,
    certification_name VARCHAR(100) NOT NULL
);

-- Table: Speaking_Languages
CREATE TABLE Speaking_Languages (
    id SERIAL PRIMARY KEY,
    language_name VARCHAR(50) NOT NULL,
    proficiency_level VARCHAR(15) CHECK (proficiency_level IN ('Native', 'Fluent', 'Intermediate', 'Beginner'))
);

-- Table: Hobbies
CREATE TABLE Hobbies (
    id SERIAL PRIMARY KEY,
    hobby_name VARCHAR(100) NOT NULL,
    description TEXT
);