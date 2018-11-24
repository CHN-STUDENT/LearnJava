/*
 * Java Experiment 05:Definition and utility class 1
 * Data:2018.9
 * Collage:Internet of Things
 * Class:IoT 1603
 * Name:GuoZhiHong 
 * Student ID:201616070320
 */

package Experiment05;

public class Experiment05 {
	public static void main(String[] args) {
		//The following code is the my exception test
        try{
            Student StudentA=new Student();
            StudentA.PrintStudentInfo();
            Student StudentB=new Student("201808","John",20,99);
            StudentB.PrintStudentInfo();
            StudentA.SetStudentInfo("201809", "Mike", 19, 88);
            StudentA.PrintStudentInfo();
            //StudentA.SetAge(-9);
            Student StudentC=new Student("201810","Alice",-10,100);
            StudentC.PrintStudentInfo();
            //In my test, there are multiple exceptions that will only throw the first exception that occurred.
        }
        catch (InsufficientFundsException e) {
            e.printStackTrace();
        }

	}
}


