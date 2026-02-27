import model.Student;
import service.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        try {
            while (true) {

                System.out.println("\n=== Student Management System ===");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Delete Student");
                System.out.println("4. Update Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student student = new Student(name, email, course);
                    service.addStudent(student);

                } else if (choice == 2) {

                    service.viewStudents();

                } else if (choice == 3) {

                    System.out.print("Enter ID to Delete: ");
                    int id = sc.nextInt();

                    service.deleteStudent(id);

                } else if (choice == 4) {

                    System.out.print("Enter ID to Update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String course = sc.nextLine();

                    service.updateStudent(id, name, email, course);

                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}12