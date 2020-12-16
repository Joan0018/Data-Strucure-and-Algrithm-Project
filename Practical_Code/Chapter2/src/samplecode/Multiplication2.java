package samplecode;

public class Multiplication2 {

  public static void main(String[] args) {

    long firstOperand = 7562;
//    long secondOperand = 423;
    long secondOperand = 1000000000;
    //long secondOperand = 100;
    int secondOperandLength = String.valueOf(secondOperand).length();
    System.out.println("***TRACE: secondOperandLength = " + secondOperandLength);

    long product = 0;
    for (int digitPosition = 1; digitPosition <= secondOperandLength; digitPosition++) {
      int digit = (int) (secondOperand - (secondOperand / 10) * 10);
      System.out.println("digit:" + digit);
      for (int counter = digit; counter > 0; counter--) {
        product = product + firstOperand;
      }
      secondOperand = secondOperand / 10; // discard last digit
      firstOperand = 10 * firstOperand; // tack zero on right
    } // end for
    System.out.print("FirstOperand: " + firstOperand + " and SecondOperand: " + secondOperand);
    System.out.println(", Final Product: " + product);

  }
}
