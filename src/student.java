import java.util.Scanner;

public class student {
    private final String[] students = new String[30];  // Array to store student names
    private final double[] studentMarks = new double[30];  // Array to store student marks
    private final boolean[] studentStatus = new boolean[30];  // Array for enrollment status
    private int studentCount = 0;  // Counter for the number of students
    private final Scanner input = new Scanner(System.in);  // Initialize input scanner
    private String studentName;



    public int addStudent(driver d) {

        if (studentCount < students.length) {
            students[studentCount] = this.getStudentName();
            studentMarks[studentCount] = 0.0;  // Initialize with 0.0 marks
            studentStatus[studentCount] = false;  // Not enrolled by default
            studentCount++;
           d.printToScreen("Student " + this.getStudentName() + " added.");
            return studentCount - 1;  // Return index of the newly added student
        } else {
            d.printToScreen("Student array is full.");
            return -1;  // Indicate that the student was not added
        }
    }

    // Add marks for a student
    public void addStudentMarks(String name, double marks ,driver d) {
        int index = findStudentIndex(name);
        if (index != -1) {
            studentMarks[index] = marks;
            d.printToScreen("Marks for " + name + " updated.");
        } else {
            d.printToScreen("Student not found.");
        }
    }

    // List all students
    public void listAllStudents(driver d) {
        d.printToScreen("All students:");
        for (int i = 0; i < studentCount; i++) {
            d.printToScreen(students[i]);
        }
    }

    // Find student index by studentName
    private int findStudentIndex(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }


    // Calculate and print average marks for a student
    public void averageMarks(int studentIndex ,driver d) {
        if (studentIndex < 0 || studentIndex >= studentCount) {
            d.printToScreen("Invalid student index.");
            return;
        }
        double studentMark = studentMarks[studentIndex];
        d.printToScreen("Average mark for student " + students[studentIndex] + ": " + studentMark);
    }

    // List students who are enrolled
    public void listEnrolledStudents(driver d) {
        d.printToScreen("Enrolled students:");
        for (int i = 0; i < studentCount; i++) {
            if (studentStatus[i]) {
                d.printToScreen(students[i]);
            }
        }
    }

    // Method to change enrollment status
    public void registerStudent(String name ,driver d) {
        int index = findStudentIndex(name);
        if (index != -1) {
            studentStatus[index] = true;
            d.printToScreen(name + " has been registered.");
        } else {
            d.printToScreen("Student not found.");
        }
    }

    public void deregisterStudent(String name, driver d) {
        int index = findStudentIndex(name);
        if (index != -1) {
            studentStatus[index] = false;
            d.printToScreen(name + " has been deregistered.");
        } else {
            d.printToScreen("Student not found.");
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
