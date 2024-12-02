public class StudentLinkedList {
    public Node head;

    public class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }
    public void addStudent(String name, double marks) {
        Student newStudent = new Student(name, marks);
        Node newNode = new Node(newStudent);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Student added successfully!");
        displayStudents(); // Hiển thị danh sách sinh viên sau khi thêm
    }
    public void editStudent(int id, String newName, double newMarks) {
        Node current = head;
        while (current != null) {
            if (current.student.getId() == id) {
                // Hiển thị thông tin cũ của sinh viên
                System.out.println("Current Student Info: ");
                System.out.println(current.student);

                // Cập nhật thông tin sinh viên
                current.student.setName(newName);
                current.student.setMarks(newMarks);
                System.out.println("Student updated successfully!");
                displayStudents(); // Hiển thị danh sách sau khi chỉnh sửa
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }
    public void deleteStudent(int id) {
        if (head == null) {
            System.out.println("No students to delete.");
            return;
        }
        if (head.student.getId() == id) {
            head = head.next;
            System.out.println("Student deleted successfully!");
            displayStudents(); // Hiển thị danh sách sau khi xóa
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.student.getId() == id) {
                current.next = current.next.next;
                System.out.println("Student deleted successfully!");
                displayStudents(); // Hiển thị danh sách sau khi xóa
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("No students to display.");
        } else {
            Node current = head;
            // In tiêu đề bảng
            System.out.printf("%-5s %-20s %-10s %-15s\n", "ID", "Name", "Marks", "Rank");
            System.out.println("-----------------------------------------------");

            while (current != null) {
                System.out.printf("%-5d %-20s %-10.2f %-15s\n", current.student.getId(), current.student.getName(),
                        current.student.getMarks(), current.student.getRank());
                current = current.next;
            }
        }
    }
    public void bubbleSort() {
        if (head == null) {
            System.out.println("No students to sort.");
            return;
        }
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.student.getMarks() > j.student.getMarks()) {
                    Student temp = i.student;
                    i.student = j.student;
                    j.student = temp;
                }
            }
        }
        System.out.println("Students sorted using Bubble Sort.");
        displayStudents();
    }
    public void selectionSort() {
        if (head == null) {
            System.out.println("No students to sort.");
            return;
        }
        for (Node i = head; i != null; i = i.next) {
            Node minNode = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (j.student.getMarks() < minNode.student.getMarks()) {
                    minNode = j;
                }
            }
            Student temp = i.student;
            i.student = minNode.student;
            minNode.student = temp;
        }
        System.out.println("Students sorted using Selection Sort.");
        displayStudents(); // Hiển thị danh sách sau khi sắp xếp
    }

    public Node findStudentById(int id) {
        Node current = head;
        while (current != null) {
            if (current.student.getId() == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void linearSearchStudentByName(String name) {
        boolean found = false;
        Node current = head;  // Start at the head of the linked list
        while (current != null) {  // Traverse the list until we reach the end
            if (current.student.getName().equalsIgnoreCase(name)) {
                System.out.println(current.student);  // Print the student details
                found = true;  // Mark that a match has been found
            }
            current = current.next;  // Move to the next node in the list
        }
        if (!found) {
            System.out.println("No student found with the name: " + name);
        }
    }

}
