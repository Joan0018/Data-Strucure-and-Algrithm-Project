package samplecode;

public class Multiplication1 {

  public static void main(String[] args) {
    long firstOperand = 7562;
//    long secondOperand = 423;
    long secondOperand = 1000000000;
    long product = 0;

    for (long counter = secondOperand; counter > 0; counter--) {
      product += firstOperand;
    }

    System.out.println("The product of " + firstOperand + " and " + secondOperand + " is " + product);

  }
}
