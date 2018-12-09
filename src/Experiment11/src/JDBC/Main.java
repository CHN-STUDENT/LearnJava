package JDBC;
//Main类，包括主方法，程序的入口

public class Main {
    public static void main(String args[]) {
        Show show=new Show();
        ConnectToDatabase connectToDatabase=new ConnectToDatabase();
        Student student=new Student(ConnectToDatabase.conn);
        Input input=new Input();
        while (true) {
            show.listShow();
            Input.resetInput();
            input.inputMenuOption();
            System.out.println("-------------------------------------");
            if(Input.menuOption==0) {
                student.dispAll();
            } else if(Input.menuOption==1) {
                Input.resetInput();
                input.inputAll();
                student.add(Input._id,Input._name,Input._grade);
            } else if(Input.menuOption==2) {
                input.inputId();
                //System.out.println(Input._id);
                student.findByID(Input._id,false);
            } else if(Input.menuOption==3) {
                input.inputName();
                //System.out.println(Input._name);
                student.findByName(Input._name);
            } else if(Input.menuOption==4) {
                input.inputId();
                student.delByID(Input._id);
            } else if(Input.menuOption==5) {
                input.inputSortMode();
                student.sortByGrade(Input.askOption);
            } else if(Input.menuOption==6) {
                input.close();
                student.close();
                connectToDatabase.close();
                System.exit(0);
            } else {
                System.out.println("Input error!");
                System.out.println("-------------------------------------");
            }
        }
    }
}

