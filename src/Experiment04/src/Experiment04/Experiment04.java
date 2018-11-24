/*
 * Java Experiment 04:Find the maximum value in the array
 * Data:2018.9
 * Collage:Internet of Things
 * Class:IoT 1603
 * Name:GuoZhiHong 
 * Student ID:201616070320
 */

package Experiment04;
import java.util.Scanner;

public class Experiment04 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		double[] array=new double[10];
		for(int i=0;i<array.length;i++) {
			System.out.println("Input array A ["+i+"]");
			array[i]=in.nextInt();
		}
		in.close();
		System.out.println("The Method 1 's reslut is "+FindTheMaximumValueInTheArrayMethod1(array));
		System.out.println("The Method 2 's reslut is "+FindTheMaximumValueInTheArrayMethod2(array));
	}
	
	
	public static double FindTheMaximumValueInTheArrayMethod1(double[] array) {
		double reslut=array[0];//set the initia value
		for (double i : array) {//for every value in the array
			if(i>reslut) //reset reslut
				reslut=i;
		}
		return reslut;
	}
	public static double FindTheMaximumValueInTheArrayMethod2(double[] array) {
		double reslut=array[0];//set the initia value
		for (int index=array.length-1;index>=2;index--) {//for every value in the array
			//index=length-1
			if(array[index]>reslut) //reset reslut
				reslut=array[index];
		}
		return reslut;
	}
	
}
