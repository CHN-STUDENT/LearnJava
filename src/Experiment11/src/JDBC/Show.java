package JDBC;

public class Show {
    public static int len=0;
    private String show[]={
            "0.显示所有学生的信息",
            "1.添加学生信息",
            "2.按学号查找",
            "3.按姓名查找",
            "4.按学号删除",
            "5.按成绩排序",
            "6.退出"
    };
    public Show() {
        super();
        len=show.length;
    }
    public void listShow() {
        for(String output:show) {
            System.out.println(output);
        }
    }
}
