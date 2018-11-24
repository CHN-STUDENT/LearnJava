/*
 * Java Experiment 09:Class and inheritance 2
 * Data:2018.9
 * Collage:Internet of Things
 * Class:IoT 1603
 * Name:GuoZhiHong
 * Student ID:201616070320
 */

/*
    Special thanks: YaoDongYang & ShiZiMo & ZhengWangWang
    They gave me the reference code,
    Also they explained the class inheritance,the Override methods and the access modifiers.
    Here are the code:

    public class Person { //The parent class of all classes is the object class
        private String name;
        private int age;
        private String sex;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getSex() {
            return sex;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }
        public Person(String name, int age, String sex) {
            //super(); It called the constructor in the parent class,The system is automatically completed, you can not write
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Person() {
            //super();
        }
        @Override
        public String toString() {//Rewrote the toString method of the Object class
            return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
        }

        public void show(){
            System.out.println("我叫"+name+", 我的年龄是："+age+", 我的性别是："+sex);
        }
        public static void main(String[] args) {
            Person p = new Person("张三", 23, "男");
            p.show();
        }

    }

*/
package Experiment09;

public class Experiment09 {
    public static void main(String []args) {
//        Person p=new Person();
//        p.talk();
        Student StudentA=new Student("John","HAUT","M",20,99,88);
        Student StudentB=new Student(77,66);
        Student StudentC=new Student();
        StudentA.talk();
        System.out.println("---------------------------------");
        StudentB.talk();
        System.out.println("---------------------------------");
        StudentC.talk();
        System.out.println("---------------------------------");
        StudentB.SetInfo("Mike","HAUT","M",19);
        StudentC.SetInfo("Alice","HAUT","F",9,55,44);
        StudentA.talk();
        System.out.println("---------------------------------");
        StudentB.talk();
        System.out.println("---------------------------------");
        StudentC.talk();
        System.out.println("---------------------------------");
    }
}

class Person {
    private String name="NULL";
    private String addr="NULL";
    private String sex="NULL";
    private int ages=0;
    Person(String name,String addr,String sex,int ages) { //Constructor
        this.name=name;
        this.addr=addr;
        this.sex=sex;
        this.ages=ages;
    }
    public void SetInfo(String name,String addr,String sex,int ages) {
        this.name=name;
        this.addr=addr;
        this.sex=sex;
        this.ages=ages;
    }
    Person() { //Overload Constructor
        super();//Call no parameter constructor in the parent class
    }
    @Override
    public String toString(){//Override the toString method of the parent class
        return "The person 's name is " + name+",\n"
                + "The person 's addr is "+addr+",\n"
                +"The person 's sex is "+sex+",\n"
                +"The person 's age is "+ages+".";
    }
    public void talk() {
        System.out.println(this.toString());
    }
}

class Student extends Person {
    private int Math=0;
    private int English=0;

    Student() {
        super();//Call no parameter constructor in the parent class
        //Sometimes you can omit not writing, the system will automatically call
    }

    Student(String name,String addr,String sex,int ages,int Math,int English) {
        super(name,addr,sex,ages);//Pass the argument to its parent class constructor
        //it can only use the construtor in the subclass
        this.Math=Math;
        this.English=English;
    }

    Student(int Math,int English){
        super();//Call no parameter constructor in the parent class
        this.Math=Math;
        this.English=English;
    }

    @Override
    public void talk(){//Override the talk method
        //the overriding requires method name, parameter types,parameter numbers, method return value must be the same
        super.talk();//Call the talk method of the parent class
        System.out.println("The person 's math grade is "+Math);
        System.out.println("The person 's math English "+Math);
    }

    public void SetInfo(String name,String addr,String sex,int ages,int Math,int English){
        /*
            This method can not be called overriding,
            because the overriding requires method name, parameter types,parameter numbers, method return value must be the same
        */
        super.SetInfo(name,addr,sex,ages);//Pass the argument to its parent class constructor
        //we have to use this method to set,because the super can only use the construtor in the subclass
        this.Math=Math;
        this.English=English;
    }
    @Override
    public void SetInfo(String name,String addr,String sex,int ages) {//Override the SetInfo method
        super.SetInfo(name, addr, sex, ages);//Pass the argument to its parent class constructor
        //we have to use this method to set,because the super can only use the construtor in the subclass
    }
}