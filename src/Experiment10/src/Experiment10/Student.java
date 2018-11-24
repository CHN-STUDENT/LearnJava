package Experiment10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {
    private String ID="NULL";
    private String name="NULL";
    private int ages=0;
    Student(String _ID,String _name,int _ages) {
        this.SetInfo(_ID,_name,_ages);
    }
    Student() {
        this.SetInfo();
    }
    public void ShowInfo() {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "The student 's ID is " + this.ID+",\n"
                + "The person 's name is "+this.name+",\n"
                +"The person 's age is "+this.ages+".";
    }
    public void SetInfo(String _ID,String _name,int _ages) {
        Scanner sc = null;
        if(_ID.matches("^[0-9]*$") == false) { //Check if the received ID value is reasonable
            sc = new Scanner(System.in);
            System.out.println("Construction error,please input the correct ID and retry again.");
            this.InputID(sc);
        }
        else {
            this.ID=_ID;
        }
        if(_name.matches("^[\\u4E00-\\u9FA5A-Za-z\\s]+(·[\\u4E00-\\u9FA5A-Za-z]+)*$")==false) {
            System.out.println("Construction error,please input the correct name and retry again.");
            this.InputName(sc);
        }
        else {
            this.name=_name;
        }
        if(_ages<0||_ages>120) {
            System.out.println("Construction error,please input the correct ages and retry again.");
            this.InputAges(sc);
        }
        else {
            this.ages=_ages;
        }
        if(sc!=null) {
            sc.close();
        }
    }
    public void SetInfo() {
        Scanner sc=new Scanner(System.in);
        this.InputID(sc);
        this.InputName(sc);
        this.InputAges(sc);
        sc.close();
    }
    private void InputName(Scanner sc) {
        String _name;
        while(true) {
            System.out.println("Please input the student's name:");
            _name=sc.next();
            if(_name.matches("^[\\u4E00-\\u9FA5A-Za-z\\s]+(·[\\u4E00-\\u9FA5A-Za-z]+)*$") == false) {
                System.out.println("Input error,please input the correct name and retry again.");
            }
            else {
                this.name=_name;
                break;
            }
        }
    }
    private void InputID(Scanner sc) {
        String _ID;
        while(true) {
            System.out.println("Please input the student's ID:");
            _ID=sc.next();
            if(_ID.matches("^[0-9]*$") == false) {
                System.out.println("Input error,please input the correct ID and retry again.");
            }
            else {
                this.ID=_ID;
                break;
            }
        }
    }
    private void InputAges(Scanner sc) {
        int _ages = 0;
        while(true) {
            System.out.println("Please input the student's ages:");
            _ages=sc.nextInt();
            if(_ages<0||_ages>120) {
                System.out.println("Input error,please input the correct name and retry again.");
            }
            else {
                this.ages=_ages;
                break;
            }
        }
    }
    public void SaveToFile(String filePath)  {
        if(!filePath.isEmpty()) {
            try {
                FileWriter f = new FileWriter(filePath,true);
                String outPut="ID: "+this.ID+" name: "+this.name+" ages: "+this.ages+"\n";
                f.write(outPut); //Written into the buffer, not yet written to the file
                f.flush(); //Flush the buffer,written to the file
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("The save file 's path input error!");
        }
    }
}
