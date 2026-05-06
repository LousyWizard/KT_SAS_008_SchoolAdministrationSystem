CREATE DATABASE IF NOT EXISTS school_db;
USE school_db;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role ENUM('Admin', 'Clerk', 'Teacher', 'Principal') NOT NULL
);

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    parent_details VARCHAR(255),
    address VARCHAR(255),
    class_name VARCHAR(20),
    section VARCHAR(10),
    prev_performance VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS fees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    amount DECIMAL(10, 2),
    status VARCHAR(20),
    FOREIGN KEY (student_id) REFERENCES students(id)
);

CREATE TABLE IF NOT EXISTS attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    date DATE,
    status ENUM('Present', 'Absent'),
    FOREIGN KEY (student_id) REFERENCES students(id)
);

CREATE TABLE IF NOT EXISTS syllabus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(20),
    subject VARCHAR(50),
    details TEXT
);

CREATE TABLE IF NOT EXISTS performance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    test_name VARCHAR(50),
    marks INT,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

CREATE TABLE IF NOT EXISTS class_schedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(20),
    subject VARCHAR(50),
    teacher_id INT,
    schedule_time VARCHAR(50),
    FOREIGN KEY (teacher_id) REFERENCES users(id)
);

-- Insert default users
INSERT IGNORE INTO users (username, password, role) VALUES 
('admin', 'admin123', 'Admin'),
('clerk', 'clerk123', 'Clerk'),
('teacher', 'teacher123', 'Teacher'),
('principal', 'principal123', 'Principal');
