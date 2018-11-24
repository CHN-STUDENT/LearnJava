/*
 * Java Experiment 08:Class and inheritance 1
 * Data:2018.9
 * Collage:Internet of Things
 * Class:IoT 1603
 * Name:GuoZhiHong
 * Student ID:201616070320
 */

/*
    Special thanks: YaoDongYang
    I completed this experiment with reference to the article on his blog.
    Title: Use of the static keyword in Java
    URL: https://blog.sunriseydy.top/technology/code/java/java-static/
*/

package Experiment08;

public class BookPress {
    public static void main(String []args) {//Main method,Executed when the class is loaded, and only executed once
        Book b1=new Book("Test Book1",20,"在路上出版社");
        Book b2=new Book("Test Book2",18,"在路上出版社");
        Book b3=new Book("Test Book3",9,"在路上出版社");
        b1.getInfo();
        b2.getInfo();
        b3.getInfo();
        //The member varialbes need to be called by its instantiated object
//        b1.SetPub("天天向上出版社");
//        b2.SetPub("天天向上出版社");
//        b3.SetPub("天天向上出版社");
        //The following code is error,because the private varialbe only can be used on its class
//        Book.pub=SetPub("天天向上出版社");
        //The following code will change the class variable,and all objects of the class which read this will change
        Book.SetPub("天天向上出版社");
        //Also,the static method only can be used by its class name
        b1.getInfo();
        b2.getInfo();
        b3.getInfo();
    }

}

class Book {
    private String title="NULL";
    private int price=0;
//    private String pub="在路上出版社";
    private static String pub="在路上出版社";
    /*
        The class variable:By using static keywork
        Only can be called by its class name,it is common to all instantiated objects of class
        If it is changed,its read by all objects of the class will change
        The member variables will be created on the memory when create an object instance
        Also,the member varialbes need to be called by its instantiated object
        But the class variable only create one on the memory and it is common to all instantiated objects of class
     */
    Book() {

    }
    Book(String title,int price,String pub) {
        this.title=title;
        this.price=price;
        this.pub=pub;
    }
    public void getInfo() {
        System.out.println("The book 's title is "+title);
        System.out.println("The book 's price is "+price);
        System.out.println("The book 's pub is "+pub);
    }
    public static void SetPub(String pub) {
        //this.pub=pub; it is error
        Book.pub=pub; //only change by this
    }
}