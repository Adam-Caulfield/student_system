import java.util.Scanner;

public class driver {

    private final Scanner input = new Scanner(System.in);  // Declare input as a class-level object
    public course courseInstance = new course();

    public void showMenu() {
        while (true) {
            this.printToScreen("\nChoose an option:");
            this.printToScreen("1) Add a student");
            this.printToScreen("2) Add student marks");
            this.printToScreen("3) Register student");
            this.printToScreen("4) Deregister student");
            this.printToScreen("5) List all students");
            this.printToScreen("6) List enrolled students");
            this.printToScreen("7) List students with average marks greater than a given value");
            this.printToScreen("8) List students with their average marks");
            this.printToScreen("9) Display average mark for all students");
            this.printToScreen("10) Display student with the lowest average mark");
            this.printToScreen("11) Display student with the highest average mark");
            this.printToScreen("12) List students who passed");
            this.printToScreen("0) Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();  // Clear the newline left by nextInt()

            switch (choice) {
                case 1:
                   this.printToScreen("Enter student name: ");
                    
                    student s = new student();
                    s.setStudentName(input.nextLine());
                    courseInstance.addStudent(this,s);
                    exitOrStay();

                    break;
                case 2:
                   this.printToScreen("Enter student name: ");
                    student s2 = new student();
                    s2.setStudentName(input.nextLine());
                    this.printToScreen("Enter marks: ");
                    double marks = input.nextDouble();
                    courseInstance.addStudentMarks(s2.getStudentName(), marks, this);
                    exitOrStay();
                    break;
                case 3:
                   this.printToScreen("Enter student name: ");
                    student s3 = new student();
                    s3.setStudentName(input.nextLine());
                    courseInstance.registerStudent(s3.getStudentName(),this);  // Register a student
                    exitOrStay();
                    break;
                case 4:
                    this.printToScreen("Enter student name: ");
                    student s4 = new student();

                    s4.setStudentName(input.nextLine());
                    courseInstance.deregisterStudent(s4.getStudentName(),this);
                    exitOrStay(); // Deregister a student
                    break;
                case 5:
                    courseInstance.listAllStudents(this);  // List all students
                    exitOrStay();
                    break;
                case 6:
                    courseInstance.listEnrolledStudents(this);  // List enrolled students
                    exitOrStay();
                    break;
                case 7:
                    this.printToScreen("Enter threshold: ");
                    double threshold = input.nextDouble();
                    courseInstance.listAboveAverageMark(threshold,this); // List students with marks above threshold

                    exitOrStay();
                    break;
                case 8:
                    courseInstance.listStudentsWithAverages(this);  // List students and their average marks
                    exitOrStay();

                    break;
                case 9:
                    courseInstance.displayAverageStudentMark(this);  // Display the average mark for all students
                    exitOrStay();
                    break;
                case 10:
                    courseInstance.displayLowestAverageMark(this);  // Display student with lowest average mark
                    exitOrStay();

                    break;
                case 11:
                    courseInstance.displayHighestAverageMark(this);  // Display student with highest average mark
                    exitOrStay();
                    break;
                case 12:
                    courseInstance.listStudentsPassed(this);
                    exitOrStay();

                    break;
                case 0:
                    this.printToScreen("Exiting program...");
                    return; // Exit the loop and program
                default:
                    this.printToScreen("Invalid choice. Please try again.");
            }
        }
    }

    public void exitOrStay() {
        this.printToScreen("Do you want to return to menu? Y for yes or N for no");
        char choice = this.input.next().toLowerCase().charAt(0);
        this.input.nextLine();

        while (choice != 'y' && choice != 'n') {
            this.printToScreen("Invalid choice. Please enter Y for yes or N for no:");
            choice = this.input.next().charAt(0);
            this.input.nextLine();
        }

        if (choice == 'n') {
            this.printToScreen("Program terminated by user");
            System.exit(0);
        }
    }

    public void printToScreen(String message){
        System.out.println(message);
    }
}


