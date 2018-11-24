package Homework2;

public class Homework2 {
    public static void main (String []args) {
        Teacher  TeacherA=new Teacher();
        TeacherA.Teach();
        Teacher  TeacherB=new Teacher("No.3",3);
        TeacherB.Teach();
    }
}

class Teacher {
    private String Name="No.2";
    private int JobTitle=2;
    Teacher() {//construor

    }
    Teacher(String _Name,int _JobTitle) {//construor
        this.Name=_Name;
        this.JobTitle=_JobTitle;
    }
    public void Teach(){
        System.out.println("Now the teacher name is "+this.Name);
        System.out.println("His (her) job title is "+this.JobTitle);
    }
}
class Computer {
    private String CpuName;
    private  int CpuPrice;
    private  String owner;
}