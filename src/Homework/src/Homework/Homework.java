package Homework;
import java.lang.Math; //Math package

public class Homework {

	public static void main(String[] args) {
		boolean flag=false;
		for(int i=100;i<=200;i++) { //100-200
			int test=(int)Math.sqrt(i);//double to int
			for(;test>=2;test--) {//2-sqrt(n)
				if(0==i%test) {//if it is prime
					flag=true;//change flag
					break;
				}	
			}
			if(flag) {//Print if it is prime
				System.out.println(i);
			}
			flag=false;//Set flag
		}
	}

}
