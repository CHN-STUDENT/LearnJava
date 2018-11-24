package Experiment05;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
            System.out.println("Error!Here are the error info:");
            System.out.println("You need to input a correct age!");
    }
}
