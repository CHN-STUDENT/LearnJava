/*
 * Java Experiment 07:Definition and utility class 3
 * Data:2018.9
 * Collage:Internet of Things
 * Class:IoT 1603
 * Name:GuoZhiHong 
 * Student ID:201616070320
 */

/*
    The relationship between various access modifiers and their access capabilities:
                                            public  protected  friendly  private
Same class                                       Y           Y       Y       Y
Same package                                     Y           Y       Y       N
Subclasses in different packages                 Y           Y       N       N
Non-subclasses in different packages             Y           N       N       N

 */

package Experiment07;

public class Experiment07 {
    public static void main(String []args) {
        Person PersonA=new Person();
        Person PersonB=new Person("Mike","M",20);
        PersonA.set("John","M",21);
        PersonA.show();
        /*
            Error code,the private member(including the private method or the private member variable) can not be used other class
            System.out.println("The person 's name is "+PersonA.name);
            System.out.println("The person 's sex is "+PersonA.sex);
            System.out.println("The person 's ages is "+PersonA.ages);
         */
        //the public method can be called in other class,so the following code can run
        System.out.println("The person 's name is "+PersonB.getName());
        System.out.println("The person 's sex is "+PersonB.getSex());
        System.out.println("The person 's ages is "+PersonB.getAge());
        Person PersonC=new Person("Mike","M",-1);
    }
}

class Person {
    private String name="NULL";
    private String sex="NULL";
    private int ages=0;
    //The private member variable only can be used its class
    Person(String name,String sex,int ages) { //Constructor

        this.name=name;
        this.sex=sex;
        if(ages>0)
            this.ages=ages;
        else
            System.out.println("Input error!");
    }

    Person () {}
    //The method can get the private member variable in the class
    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return ages;
    }

    public void set(String name,String sex,int ages) {
        this.name=name;
        this.sex=sex;
        if(ages>0)
            this.ages=ages;
        else
            System.out.println("Input error!");
    }

    public void show() { //show method
        //Its has the public access permission,so it can be called in its class,its package,other classes and other packages
        System.out.println("The person 's name is "+name);
        System.out.println("The person 's sex is "+sex);
        System.out.println("The person 's ages is "+ages);
    }
}
