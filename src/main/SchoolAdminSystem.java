package main;

import dao.SchoolDAO;
import model.Student;
import model.User;

import java.util.Scanner;

public class SchoolAdminSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static SchoolDAO dao = new SchoolDAO();
    private static User loggedInUser = null;

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("  Welcome to School Administration System");
        System.out.println("=========================================");

        while (true) {
            if (loggedInUser == null) {
                login();
            } else {
                showMenu();
            }
        }
    }

    private static void login() {
        System.out.print("\nEnter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        loggedInUser = dao.login(username, password);

        if (loggedInUser != null) {
            System.out.println("Login Successful! Welcome " + loggedInUser.getRole() + " " + loggedInUser.getUsername());
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void showMenu() {
        System.out.println("\n--- " + loggedInUser.getRole() + " Menu ---");
        switch (loggedInUser.getRole()) {
            case "Clerk":
                System.out.println("1. Admit Student");
                System.out.println("2. Process Fee Payment");
                break;
            case "Teacher":
                System.out.println("1. Mark Attendance");
                System.out.println("2. Add Syllabus");
                System.out.println("3. Manage Performance (Class Tests)");
                break;
            case "Principal":
                System.out.println("1. Schedule Class-Subjects-Teachers");
                System.out.println("2. View Reports");
                System.out.println("3. Analyze Performance");
                break;
            case "Admin":
                System.out.println("1. System Settings (Placeholder)");
                break;
        }
        System.out.println("0. Logout");
        System.out.print("Choose an option: ");
        
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        if (choice == 0) {
            loggedInUser = null;
            System.out.println("Logged out successfully.");
            return;
        }

        switch (loggedInUser.getRole()) {
            case "Clerk":
                if (choice == 1) admitStudentFlow();
                else if (choice == 2) feePaymentFlow();
                break;
            case "Teacher":
                if (choice == 1) markAttendanceFlow();
                else if (choice == 2) addSyllabusFlow();
                else if (choice == 3) managePerformanceFlow();
                break;
            case "Principal":
                if (choice == 1) scheduleClassFlow();
                else if (choice == 2 || choice == 3) generateReportsFlow();
                break;
            default:
                System.out.println("Invalid Option.");
        }
    }

    private static void admitStudentFlow() {
        System.out.println("\n-- Admit Student --");
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Parent Details: "); String parent = scanner.nextLine();
        System.out.print("Address: "); String address = scanner.nextLine();
        System.out.print("Class (e.g., 10A): "); String className = scanner.nextLine();
        System.out.print("Section: "); String section = scanner.nextLine();
        System.out.print("Previous Performance: "); String prev = scanner.nextLine();

        Student s = new Student(name, parent, address, className, section, prev);
        if (dao.admitStudent(s)) {
            System.out.println("Student Admitted Successfully!");
        } else {
            System.out.println("Failed to admit student.");
        }
    }

    private static void feePaymentFlow() {
        System.out.println("\n-- Process Fee Payment --");
        System.out.print("Enter Student ID: "); int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Amount: "); double amount = Double.parseDouble(scanner.nextLine());
        dao.processFeePayment(id, amount);
    }

    private static void markAttendanceFlow() {
        System.out.println("\n-- Mark Attendance --");
        System.out.print("Enter Student ID: "); int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Date (YYYY-MM-DD): "); String date = scanner.nextLine();
        System.out.print("Status (Present/Absent): "); String status = scanner.nextLine();
        dao.markAttendance(id, date, status);
    }

    private static void addSyllabusFlow() {
        System.out.println("\n-- Add Syllabus --");
        System.out.print("Class Name: "); String className = scanner.nextLine();
        System.out.print("Subject: "); String subject = scanner.nextLine();
        System.out.print("Details: "); String details = scanner.nextLine();
        dao.addSyllabus(className, subject, details);
    }

    private static void managePerformanceFlow() {
        System.out.println("\n-- Manage Performance --");
        System.out.print("Enter Student ID: "); int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Test Name: "); String testName = scanner.nextLine();
        System.out.print("Marks: "); int marks = Integer.parseInt(scanner.nextLine());
        dao.addPerformance(id, testName, marks);
    }

    private static void scheduleClassFlow() {
        System.out.println("\n-- Schedule Class --");
        System.out.print("Class Name: "); String className = scanner.nextLine();
        System.out.print("Subject: "); String subject = scanner.nextLine();
        System.out.print("Teacher ID: "); int teacherId = Integer.parseInt(scanner.nextLine());
        System.out.print("Schedule Time (e.g., 10:00 AM): "); String time = scanner.nextLine();
        dao.scheduleClass(className, subject, teacherId, time);
    }

    private static void generateReportsFlow() {
        System.out.println("\n-- Generating Reports --");
        dao.generateReports();
    }
}
