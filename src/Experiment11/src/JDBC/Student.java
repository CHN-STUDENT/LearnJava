package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    private PreparedStatement preparedStatement=null;
    private Connection conn = null;
    private String _name=null;
    private String _id="";
    private double _grade=0.0;
    private boolean isFonud=false;
    public Student (Connection conn) {
        super();
        this.conn=conn;
    }
    public void add(String id,String name,double grade) {
        //System.out.println(id);
        findByID(id,true);//删除模式
        if(!isFonud) {
            //添加学生信息
            String sql="INSERT INTO Student(id,name,grade) values (?,?,?)";
            try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.setDouble(3,grade);
                preparedStatement.executeUpdate();
                System.out.println("OK");
                System.out.println("-------------------------------------");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            isFonud = false;
            //要求确认是否要更新信息，如果是更新则更新
            //做出预判是否可以更新
            System.out.println("您是否要更新该学生信息？");
            Input.inputAskOption();
            if(Input.askOption) {
                String sql = "UPDATE Student SET name=?,grade=? WHERE id=?";
                while(true) {
                    if(name.equals(_name)&&grade==_grade) {//如果输入的数据和原来数据相同则要求重输
                        System.out.println("对不起，输入的数据和源数据一样，请您输入不同的数据！");
                        Input.inputName();
                        Input.inputGrade();
                    } else { //更新数据
                        break;
                    }
                }
                try {
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, Input._name);
                    preparedStatement.setDouble(2, Input._grade);
                    preparedStatement.setString(3, id);
                    preparedStatement.executeUpdate();
                    System.out.println("OK");
                    System.out.println("-------------------------------------");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void dispAll() {
        String sql="SELECT * FROM Student";
        try {
            preparedStatement=conn.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery(); //本方法适用与查询语句
            if(rs.next()){
                isFonud=true; //有学生信息
                rs.beforeFirst();
                System.out.println("id        name        grade");
                while (rs.next()) {
                    _name=rs.getString("name");
                    _id=rs.getString("id");
                    _grade=rs.getDouble("grade");
                    //System.out.println(_id+"   "+_name+"  "+_grade);
                    System.out.printf("%-10s%-10s%3.2f\n",_id,_name,_grade);
                }
            }
            if(!isFonud) { //没有学生信息
                System.out.println("没有学生信息显示，请您输入学生信息");
                isFonud=false;
            }
            System.out.println("-------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void findByID(String id,boolean delMode) {
        if(!delMode) {
            System.out.println("-------------------------------------");
            System.out.println("从学号查询学生：");
        }
        String sql="SELECT * FROM Student WHERE id=\""+id+"\""; // SELECT * FROM Student WHERE ID="XXXXX"; \"是转义输出"
        //System.out.println(sql);
        try {
            preparedStatement=conn.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery(); //本方法适用与查询语句
            if(rs.next()) {
                rs.beforeFirst();
                isFonud=true; //有学生信息
                if(!delMode)
                    System.out.println("id        name        grade");
                while (rs.next()) {
                    _name=rs.getString("name");
                    _id=rs.getString("id");
                    _grade=rs.getDouble("grade");
                    if(!delMode) {
                        //System.out.println(_id+"   "+_name+"  "+_grade);
                        System.out.printf("%-10s%-10s%3.2f\n",_id,_name,_grade);
                        System.out.println("-------------------------------------");
                    }
                }
            } else { //没有学生信息
                if(!delMode) {
                    System.out.println("没有查询到该学生的信息！");
                }
                isFonud=false;
                System.out.println("-------------------------------------");
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void findByName(String name) {
        System.out.println("-------------------------------------");
        System.out.println("从名字查询学生：");
        String sql="SELECT * FROM Student WHERE name=?"; // 这是另外一种查询方法
        try {
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,name); //替换第一个？为String类型的name
            ResultSet rs=preparedStatement.executeQuery(); //本方法适用与查询语句
            if(rs.next()){
                rs.beforeFirst();
                isFonud=true; //有学生信息
                System.out.println("id        name        grade");
                while (rs.next()) {
                    _name=rs.getString("name");
                    _id=rs.getString("id");
                    _grade=rs.getDouble("grade");
                    //System.out.println(_id+"   "+_name+"  "+_grade);
                    System.out.printf("%-10s%-10s%3.2f\n",_id,_name,_grade);
                }
            } else { //没有学生信息
                System.out.println("没有查询到该学生的信息");
                isFonud=false;
            }
            System.out.println("-------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delByID(String id) {
        System.out.println("-------------------------------------");
        System.out.println("通过学号删除信息：");
        findByID(id,true);//删除模式
        if(!isFonud) {
            System.out.println("没有查询到要删除的该学生的信息，无法删除");
            System.out.println("-------------------------------------");
        } else {
            isFonud=false;
            String sql="DELETE FROM Student WHERE id=\""+id+"\"";
            try {
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
                System.out.println("删除以下学生信息成功：");
                System.out.println("id        name        grade");
                //System.out.println(_id+"   "+_name+"  "+_grade);
                System.out.printf("%-10s%-10s%3.2f\n",_id,_name,_grade);
                System.out.println("-------------------------------------");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public void sortByGrade(boolean isASC) {
        System.out.println("按照成绩排序学生：");
        System.out.println("-------------------------------------");
        String mode="ASC";
        if(!isASC)
            mode="DESC";
        String sql="SELECT * FROM Student ORDER BY grade"+" "+mode; // 可以选择如何排序
        try {
            preparedStatement=conn.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery(); //本方法适用与查询语句
            if(rs.next()){
                isFonud=true; //有学生信息
                rs.beforeFirst();
                System.out.println("id        name        grade");
                while (rs.next()) {
                    _name=rs.getString("name");
                    _id=rs.getString("id");
                    _grade=rs.getDouble("grade");
                    //System.out.println(_id+"       "+_name+"      "+_grade);
                    System.out.printf("%-10s%-10s%3.2f\n",_id,_name,_grade);
                }
            }
            if(!isFonud) { //没有学生信息
                System.out.println("没有学生的信息所供排序！");
            }
            System.out.println("-------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            if (preparedStatement != null)
                preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
