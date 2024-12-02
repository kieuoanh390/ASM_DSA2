import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n=== Student Management ===");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Search Students");
                System.out.println("5. Display Students");
                System.out.println("6. Sort Students (Bubble Sort)");
                System.out.println("7. Sort Students (Selection Sort)");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine()); // Try-catch on menu input

                switch (choice) {
                    case 1 -> {
                        String name = "";
                        while (true) {
                            System.out.print("Enter Student Name: ");
                            name = scanner.nextLine();
                            if (name.matches("[a-zA-Z\\s]+")) {
                                break; // Exit the loop if name is valid
                            } else {
                                System.out.println("Error: Name can only contain letters and spaces. Please enter again.");
                            }
                        }
                        double marks = -1;
                        while (true) {
                            System.out.print("Enter Student Marks (0-10): ");
                            try {
                                marks = Double.parseDouble(scanner.nextLine());
                                if (marks >= 0 && marks <= 10) {
                                    break; // Exit the loop if marks are valid
                                } else {
                                    System.out.println("Error: Marks must be between 0 and 10. Please enter again.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Invalid input. Please enter a valid number.");
                            }
                        }

                        studentList.addStudent(name, marks);
                    }

                    case 2 -> {
                        try {
                            System.out.print("Enter Student ID to edit: ");
                            int id = Integer.parseInt(scanner.nextLine());

                            // Tìm sinh viên theo ID
                            StudentLinkedList.Node studentNode = studentList.findStudentById(id);
                            if (studentNode != null) {
                                // Hiển thị thông tin cũ của sinh viên
                                System.out.println("Current Info: ");
                                System.out.println(studentNode.student);

                                // Yêu cầu nhập thông tin mới
                                String newName = "";
                                while (true) {
                                    System.out.print("Enter New Name: ");
                                    newName = scanner.nextLine();
                                    if (newName.matches("[a-zA-Z\\s]+")) {
                                        break; // Exit the loop if name is valid
                                    } else {
                                        System.out.println("Error: Name can only contain letters and spaces. Please enter again.");
                                    }
                                }

                                double newMarks = -1;
                                while (true) {
                                    System.out.print("Enter New Marks (0-10): ");
                                    try {
                                        newMarks = Double.parseDouble(scanner.nextLine());
                                        if (newMarks >= 0 && newMarks <= 10) {
                                            break; // Exit the loop if marks are valid
                                        } else {
                                            System.out.println("Error: Marks must be between 0 and 10. Please enter again.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Error: Invalid input. Please enter a valid number.");
                                    }
                                }

                                studentList.editStudent(id, newName, newMarks); // Cập nhật thông tin
                            } else {
                                System.out.println("Student not found.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid input. Please enter a valid number.");
                        } catch (Exception e) {
                            System.out.println("An unexpected error occurred: " + e.getMessage());
                        }
                    }

                    case 3 -> {
                        try {
                            System.out.print("Enter Student ID to delete: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            studentList.deleteStudent(id);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid input. Please enter a valid number.");
                        } catch (Exception e) {
                            System.out.println("An unexpected error occurred: " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        System.out.print("Enter name to search: ");
                        String name = scanner.nextLine();
                        studentList.linearSearchStudentByName(name);
                    }

                    case 5 -> studentList.displayStudents();

                    case 6 -> {
                        try {
                            studentList.bubbleSort();            // Gọi phương thức Bubble Sort
                            System.out.println("Bubble Sort on LinkedList completed.");
                        } catch (Exception e) {
                            System.out.println("An error occurred while sorting students using Bubble Sort: " + e.getMessage());
                        }
                    }

                    case 7 -> {
                        try {
                            studentList.selectionSort();         // Gọi phương thức Selection Sort
                            System.out.println("Selection Sort on LinkedList completed.");
                        } catch (Exception e) {
                            System.out.println("An error occurred while sorting students using Selection Sort: " + e.getMessage());
                        }
                    }

                    case 8 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please select from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
