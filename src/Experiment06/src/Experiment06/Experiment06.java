/*
 * Java Experiment 06:Definition and utility class 2
 * Data:2018.9
 * Collage:Internet of Things
 * Class:IoT 1603
 * Name:GuoZhiHong 
 * Student ID:201616070320
 */


package Experiment06;
import java.util.Scanner;

public class Experiment06 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Rectangle RectangleA=new Rectangle();
		Rectangle RectangleB=new Rectangle(20.18,19.98);
		double length=0.0;
		double width=0.0;
		do {
			System.out.println("Input the rectangle length:");
			length=in.nextDouble();
			System.out.println("Input the rectangle width:");
			width=in.nextDouble();
			if(!(length>0&&width>0)) 
				System.out.println("Input Error,please retry!");
			else
				break;
		}while(true);
		in.close();
		
		RectangleA.SetRectangle(length, width);
		System.out.println("The rectangle A 's area is " + RectangleA.GetArea());
		System.out.println("The rectangle A 's perimeter is " + RectangleA.GetPerimeter());
		System.out.println("The rectangle B 's area is " + RectangleB.GetArea());
		System.out.println("The rectangle B 's perimeter is " + RectangleB.GetPerimeter());
		
	}
	
}


class Rectangle {
	double length=0.0;
	double width=0.0;
	
	public Rectangle(double length,double width) {
		this.length=length;
		this.width=width;
	}
	
	public Rectangle() {}
	
	
	public void SetRectangle(double length,double width) {
		this.length=length;
		this.width=width;
	}
	
	double GetArea() {
		return length*width;
	}
	
	double GetPerimeter() {
		return 2.0*(length+width);
	}				
	
}
