package Experiment05;

public class Student {//Delimit Class student
    String StudentID; //String StudentID="NULL"; Initialize member variables
    String Name;
    int age;
    int grade;


    public Student() {//Reloading Constructor
        this.StudentID="NULL";
        this.Name="NULL";
        this.age=0;
        this.grade=0;
        //SetStudentInfo("NULL","NULL",0,0);
    }

    public Student(String StudentID,String Name,int age,int grade) throws InsufficientFundsException {//Constructor(without values,auto set defalut values)
        //SetStudentInfo(StudentID,Name,age,grade);//calling the set method
        this.StudentID=StudentID;
        this.Name=Name;
        if (age>100||age<0) {
            throw new InsufficientFundsException();
        } else
            this.age=age;
        this.grade=grade;

    }


    public void SetStudentInfo(String StudentID,String Name,int age,int grade) throws InsufficientFundsException {//set values
        this.StudentID=StudentID;
        this.Name=Name;
        if (age>100||age<0) {
            throw new InsufficientFundsException();
        } else
            this.age=age;
        this.grade=grade;
    }
//
//	public void SetStudentInfo() { //Overload set method to set the defalut values
//		SetStudentInfo("NULL","NULL",0,0);
//	}

    public void PrintStudentInfo() {
        System.out.println("There is the student's info:");
        System.out.println("Student ID: "+StudentID);
        System.out.println("Name: "+Name);
        System.out.println("Age: "+age);
        System.out.println("Grade: "+grade);
    }

    public void SetStudentID(String StudentID) {
        this.StudentID=StudentID;
    }

    public String GetStudentID() {
        return StudentID;
    }

    public void SetName(String Name) {
        this.Name=Name;
    }

    public String GetName() {
        return Name;
    }

    public void SetAge(int age) throws InsufficientFundsException {
        if (age>100||age<0)
            throw new InsufficientFundsException();
        else
            this.age=age;
    }

    public int GetAge() {
        return age;
    }

    public void SetGrade(int grade) {
        this.grade=grade;
    }

    public int GetGrade () {
        return grade;
    }

}

