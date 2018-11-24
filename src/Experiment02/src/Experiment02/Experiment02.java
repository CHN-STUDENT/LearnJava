/*
 * Java Experiment 02:Daffodil number
 * Data:2018.9
 * Collage:Internet of Things
 * Class:IoT 1603
 * Name:GuoZhiHong 
 * Student ID:201616070320
 */

package Experiment02;

public class Experiment02 {

	public static void main(String[] args) {
		int testnum1=234;
		var testnum2=234; /*
							  This is new characteristic in JDK10
			                  It can do the Local-Variable Type Inference.
			                  See here:
							  JEP 286: Local-Variable Type Inference<http://openjdk.java.net/jeps/286>
							  Chinese version:https://segmentfault.com/a/1190000013612633
						  */
		int singledigit1=testnum1%10;
		var singledigit2=testnum2%10;
		int ten1=testnum1%100/10;
		var ten2=testnum1%100/10;
		int hundreds1=testnum1/100;
		var hundreds2=testnum1/100;		
		boolean reslut1,reslut2;
		reslut1=(testnum1==singledigit1*singledigit1*singledigit1+ten1*ten1*ten1+hundreds1*hundreds1*hundreds1);
		System.out.println("Test 1 reslut is "+reslut1);
		reslut2=(testnum2==singledigit2*singledigit2*singledigit2+ten2*ten2*ten2+hundreds2*hundreds2*hundreds2);
		System.out.println("Test 2 reslut is "+reslut2);
	}

}