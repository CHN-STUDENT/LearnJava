/*
 * Java Experiment 03:Matrix multiplication
 * Data:2018.9
 * Collage:Internet of Things
 * Class:IoT 1603
 * Name:GuoZhiHong 
 * Student ID:201616070320
 */

package Experiment03;

import java.util.Scanner;

public class Experiment03 {

	public static void main(String[] args) {
		double[][] a=new double[3][3];
		double[][] b=new double[3][3];
		
		Scanner in1 = new Scanner(System.in);
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.println("Input martix A ["+i+"]["+j+"]:");
				a[i][j] = in1.nextInt();
			}
		}
		
		Scanner in2 = new Scanner(System.in);
		for (int i = 0; i < b[0].length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.println("Input martix B ["+i+"]["+j+"]:");
				b[i][j] = in2.nextInt();
			}
		}
		
		in1.close();
		in2.close();
		
		double[][] reslut=MatrixMultiplication(a,b);
		
		for(int i=0;i<reslut[0].length;i++) { //Print reslut matrix
			for(int j=0;j<reslut.length;j++) {
					System.out.print(" "+reslut[i][j]+" ");
				}
				System.out.print("\n");		
		}
	}
	public static double[][] MatrixMultiplication(double[][] a,double[][] b) {
		
		if(a.length!=b[0].length) {//if they have different matrix dimensions
			System.out.println("Input Matrixs have different matrix dimensions!");
			return null;
		}
			
		//else
		double[][] reslut=new double[a[0].length][b.length];
		for(int i=0;i<a[0].length;i++) {
			for(int j=0;j<b.length;j++) {
				reslut[i][j]=0;
				for(int k=0;k<a.length;k++) {
			    //for(int k=0;k<b[0].length;k++) {
					reslut[i][j]+=a[i][k]*b[k][j];
				}
			}		
		}
		return reslut;
	}

}
