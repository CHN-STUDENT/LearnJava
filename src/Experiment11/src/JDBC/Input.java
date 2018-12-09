package JDBC;

import java.util.Scanner;

public class Input {
    public static String _id="";
    public static double _grade=0.0;
    public static String _name=null;
    public static int menuOption=0;
    public static boolean askOption=false;
    private static Scanner scanner=null;
    public Input() {
        super();
        scanner=new Scanner(System.in);
    }
    public void inputAll() {
        inputId();
        Input.inputName();
        Input.inputGrade();
    }
    public void inputId() {
        String _ID;
        while(true) {
            System.out.println("Please input the student's ID:");
            _ID=scanner.next();
            if(_ID.matches("^[0-9]{1,12}") == false) {
                System.out.println("Input error,please input the correct ID and retry again.");
            }
            else {
                this._id=_ID;
                break;
            }
        }
    }
    public static void inputName() {
        String _name;
        while(true) {
            System.out.println("Please input the student's name:");
            _name=scanner.next();
            if(_name.matches("^[\\u4E00-\\u9FA5A-Za-z\\s]+(·[\\u4E00-\\u9FA5A-Za-z]+)*$") == false) {
                System.out.println("Input error,please input the correct name and retry again.");
            }
            else {
                Input._name=_name;
                break;
            }
        }
    }
    public static void inputGrade() {
        double _grade = 0.0;
        while(true) {
            System.out.println("Please input the student's grade:");
            _grade= scanner.nextDouble();
            if(_grade<0.0||_grade>100.0) {
                System.out.println("Input error,please input the correct grade and retry again.");
            }
            else {
                Input._grade=_grade;
                break;
            }
        }
    }
    public void inputMenuOption() {
        menuOption=0;
        int len=Show.len-1;
        //System.out.println(len);
        String regex="^[0-9]+$";
        String input;
        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("Please input your option (0 to "+len+")");
            input=scanner.next();
            if(input.matches(regex)==false) {
                System.out.println("Input error,please input your option and retry again.");
            } else {
                menuOption=Integer.parseInt(input);
                break;
            }
        }
    }
    public void inputSortMode() {
        askOption=false;
        String _askOption;
        while(true) {
            //System.out.println("-------------------------------------");
            System.out.println("Please input 1 to ASC, input 2 to DESC:");
            _askOption=scanner.next();
            if(_askOption.matches("^[1,2]$") == false) {
                System.out.println("Input error,please input the your option and retry again.");
            } else {
                int input=Integer.parseInt(_askOption);
                if(input==1)
                    askOption=true;
                else
                    askOption=false;
                break;
            }
        }
    }
    public static void inputAskOption() {
        askOption=false;
        String _askOption;
        while(true) {
            System.out.println("-------------------------------------");
            System.out.println("Please input 1 to OK, input 2 to Cancel:");
            _askOption=scanner.next();
            if(_askOption.matches("^[1,2]$") == false) {
                System.out.println("Input error,please input the your option and retry again.");
            } else {
                int input=Integer.parseInt(_askOption);
                if(input==1)
                    askOption=true;
                else
                    askOption=false;
                break;
            }
        }
    }
    public void close() {
        scanner.close();
    }
}
