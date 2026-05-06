# School Administration System (KT_SAS_008)

## Project Overview
A comprehensive, role-based School Administration System built with Java and MySQL. This application streamlines school management by providing dedicated interfaces for different stakeholders (Admin, Clerk, Teacher, Principal), automating administrative tasks, and ensuring data integrity.

## Key Features

### 1. Role-Based Access Control
Secure authentication system with four distinct user roles:
- **Admin**: Full system control, database management.
- **Clerk**: Handles admissions, fees, and basic student records.
- **Teacher**: Manages attendance, marks, and class performance.
- **Principal**: Oversees scheduling, report generation, and analytics.

### 2. Streamlined Operations
- **Admissions**: Digital student admission forms with auto-generated IDs.
- **Fees Management**: Track payments, manage dues, and generate receipts.
- **Attendance**: Daily attendance tracking by teachers.
- **Academics**: Mark entry and performance tracking.

### 3. Reporting & Analytics
- **Automated Reports**: Generate comprehensive reports for any date range.
- **Data Export**: Export data to PDF for official records.
- **Performance Dashboards**: Quick insights into school performance.

### 4. Technical Architecture
- **Frontend**: Java Swing with JavaFX WebView for reports.
- **Backend**: MySQL Database.
- **Connectivity**: JDBC (Java Database Connectivity).

## Getting Started

### Prerequisites
- **Java Development Kit (JDK)** 8 or higher.
- **MySQL Server** 5.7 or higher.
- **MySQL Connector/J** (Driver).

### Installation & Setup

#### 1. Database Setup
1. Start your MySQL Server.
2. Import the `school_admin.sql` script to create the database and tables:
   ```bash
   mysql -u root -p < school_admin.sql
   ```
3. Ensure the database connection in the Java code matches your MySQL credentials.

#### 2. Build & Run
1. **Compile** the Java files:
   ```bash
   javac -cp mysql-connector-j-X.X.X.jar:. *.java
   ```
   *(Note: Replace `mysql-connector-j-X.X.X.jar` with your actual connector JAR name)*

2. **Run** the application:
   ```bash
   java -cp mysql-connector-j-X.X.X.jar:. Main
   ```

## Project Structure
```
SchoolAdministrationSystem/
├── com/sasa/
│   ├── admin/
│   ├── clerk/
│   ├── teacher/
│   ├── principal/
│   ├── gui/
│   └── util/         # Database utilities and helpers
├── mysql-connector-j-X.X.X.jar  # DB Driver
├── school_admin.sql  # Database schema
└── README.md
```

## Database Schema
You can find the detailed Entity Relationship Diagram [here](ER_DIAGRAM.md).

### Key Tables:
- `users`: System credentials for all roles.
- `students`: Personal and academic details of students.
- `fees`: Payment records and dues.
- `attendance`: Daily attendance logs.
- `classes`: Class and section management.

## License
This project is developed for educational purposes as part of the Knowledge Transfer Program (KTP).
