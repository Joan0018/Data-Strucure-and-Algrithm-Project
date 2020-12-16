package samplecode;

/**
 * Factorial.java Computes the factorial of a given number using recursion.
 * @author Kat Tan
 */
public class Factorial {

  public int factorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }

}
