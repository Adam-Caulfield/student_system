import java.util.Scanner;

public class course {
    private final student[] studentsArr = new student[30];//set studentArr as the array of student names
    private final double[] studentMarks = new double[30];//set studentMarks as the array of their marks
    private final boolean[] studentStatus = new boolean[30];//student status is to determine if they are in enrolled default being true
    private int studentCount = 0;
    private final Scanner input;
    private String courseName;
    private double PASSGRADE = 50.0;


    public course() {
        this.input = new Scanner(System.in);
    }

    public boolean[] getStudentStatus() {
        return this.studentStatus;
    }


    private boolean isEmpty() {
        return this.studentsArr.length == 0;
    }

    private boolean isFull() {
        return this.studentCount >= this.studentsArr.length;
    }

    public Error addStudent(driver d, student s) {

        if (this.isFull()) {
            d.printToScreen("Cannot add more course is full.");
            return new Error("Cannot add more course is full.");
        } else {
            this.studentsArr[this.studentCount] = s;

            this.studentMarks[this.studentCount] = 0.0;
            this.studentStatus[this.studentCount] = false;
            ++this.studentCount;
            d.printToScreen("Student " + s.getStudentName() + " added.");
            registerStudent(s.getStudentName(), d);
            return null;
        }
    }

    private int findStudent(String name) {
        for (int i = 0; i < this.studentCount; ++i) {
            if (this.studentsArr[i].getStudentName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public void addStudentMarks(String name, double marks, driver d) {
        int index = this.findStudent(name);
        if (index == -1) {
            d.printToScreen("Student not found.");
        } else {
            this.studentMarks[index] = marks;
            d.printToScreen("Marks for " + name + " updated.");
        }

    }


    public void registerStudent(String name, driver d) {
        int index = this.findStudent(name);
        if (index != -1) {
            getStudentStatus()[index] = true;
            d.printToScreen(name + " has been registered.");
        } else {
            d.printToScreen("Student not found.");
        }

    }

    public void deregisterStudent(String name, driver d) {
        int index = this.findStudent(name);
        if (index != -1) {
            this.studentStatus[index] = false;
            d.printToScreen(name + " has been deregistered.");
        } else {
            d.printToScreen("Student not found.");
        }

    }

    public void listAllStudents(driver d) {
        d.printToScreen("All students:");

        for (int i = 0; i < this.studentCount; ++i) {
            d.printToScreen(this.studentsArr[i].getStudentName());
        }

    }

    public void listEnrolledStudents(driver d)//method to list enrolled students
    {
        d.printToScreen("Enrolled students:");

        for (int i = 0; i < this.studentCount; ++i)//looping through students
        {
            if (this.studentStatus[i]) //checking if they are enrolled
                 {
                d.printToScreen(this.studentsArr[i].getStudentName());//if they are enrolled print their name
            }
        }

    }

    public void listAboveAverageMark(double threshold, driver d)//lists marks above an average
    {
        d.printToScreen("Students with marks above " + threshold + ":");

        for (int i = 0; i < this.studentCount; ++i)//looping through students
        {
            if (this.studentMarks[i] > threshold)//comparing their marks with the threshold
            {
                d.printToScreen(this.studentsArr[i].getStudentName());//get their name
            }
        }

    }

    public void listStudentsWithAverages(driver d)//method to list every students average
    {
        d.printToScreen("Students with their average marks:");

        for (int i = 0; i < this.studentCount; ++i)//looping through students
        {

            d.printToScreen(this.studentsArr[i].getStudentName() + ": " + this.studentMarks[i]);//print their marks and name

        }

    }

    public void displayAverageStudentMark(driver d)//method for printing the average for the course
    {
        double total = 0.0;

        for (int i = 0; i < this.studentCount; ++i) //looping through students
        {
            total += this.studentMarks[i];//adding their marks together
        }

        double average = total / (double) this.studentCount;//dividing by amount of students
        d.printToScreen("Average mark for all studentsArr: " + average);//giving the result
    }

    public void displayLowestAverageMark(driver d) //method for checking lowest average
    {
        if (this.studentCount == 0)//check if course is empty
        {
            d.printToScreen("No students available.");
        } else {
            double min = Double.MAX_VALUE;
            String lowestStudent = "";

            for (int i = 0; i < this.studentCount; ++i)//loop through students
            {
                if (this.studentMarks[i] < min)//if the student mark is lower then min it is now min
                {
                    min = this.studentMarks[i];
                    lowestStudent = this.studentsArr[i].getStudentName();//gets name of student
                }
            }

            d.printToScreen("Student with the lowest average mark: " + lowestStudent + " (" + min + ")");
        }
    }

    public void displayHighestAverageMark(driver d)
    {
        if (this.studentCount == 0) {
            d.printToScreen("No studentsArr available.");
        } else {
            double max = Double.MIN_VALUE;
            String highestStudent = "";

            for (int i = 0; i < this.studentCount; ++i) {
                if (this.studentMarks[i] > max) {
                    max = this.studentMarks[i];
                    highestStudent = this.studentsArr[i].getStudentName();
                }
            }

            d.printToScreen("Student with the highest average mark: " + highestStudent + " (" + max + ")");
        }
    }

    public void listStudentsPassed(driver d) {
        if (this.studentCount == 0) {
            d.printToScreen("No studentsArr in course");
        } else {
            d.printToScreen("Students who passed:");

            for (int i = 0; i < this.studentCount; ++i) {
                if (this.studentMarks[i] >= this.PASSGRADE) {
                    d.printToScreen(this.studentsArr[i].getStudentName());
                }
            }
        }

    }
}

