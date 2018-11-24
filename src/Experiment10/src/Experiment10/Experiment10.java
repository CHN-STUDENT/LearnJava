/*
 * Java Experiment 10:  I/O Stream
 * Data:2018.9
 * Collage:Internet of Things
 * Class:IoT 1603
 * Name:GuoZhiHong
 * Student ID:201616070320
 */

package Experiment10;

public class Experiment10 {
    public static void main(String[] args) {
        IOStream io= new IOStream();
        IOStream.InputClass InputClassTest=io.new InputClass();
        //ListFile Test
        System.out.println("----------------------------------------");
        System.out.println("The ListFile Test output is:");
        System.out.println("----------------------------------------");
        InputClassTest.ListAllFileInTheDirectory("D:\\");
        //Reader Read by Char Test
        System.out.println("----------------------------------------");
        System.out.println("Reader Read by Char Test output is:");
        System.out.println("----------------------------------------");
        InputClassTest.CharReader("D:\\test.txt");
        //Reader Read by Buffer Test
        System.out.println("----------------------------------------");
        System.out.println("Reader Read by Buffer Test output is:");
        System.out.println("----------------------------------------");
        InputClassTest.BufferReader("D:\\test.txt");
        //InputStream Read by Char Test
        System.out.println("----------------------------------------");
        System.out.println("InputStream Read by Char Test output is:");
        System.out.println("----------------------------------------");
        InputClassTest.CharInputStream("D:\\test.txt");
        //InputStream Read by Buffer Test
        System.out.println("----------------------------------------");
        System.out.println("InputStream Read by Buffer Test output is:");
        System.out.println("----------------------------------------");
        InputClassTest.BufferInputStream("D:\\test.txt");
        //Copy The Image And Text File Test
        IOStream.OutputClass OutputClassTest=io.new OutputClass();
        OutputClassTest.CopyTextFile("D:\\test.txt","D:\\test2.txt");
        OutputClassTest.CopyImageFile("D:\\road.jpg","D:\\road2.jpg");
        //Student Class Test
        System.out.println("----------------------------------------");
        System.out.println("Start to test student class.");
        System.out.println("----------------------------------------");
        Student StudentA=new Student();
        StudentA.ShowInfo();
        StudentA.SaveToFile("D:\\student.txt");
        Student StudentB=new Student("002","Mike",20);
        StudentB.ShowInfo();
        StudentB.SaveToFile("D:\\student.txt");
    }

}


