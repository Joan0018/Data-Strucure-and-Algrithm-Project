package samplecode;

import java.util.*;

public class StringReversal {
  
  public String reverse(String inputString) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < inputString.length(); ++i) {
      stack.push(inputString.charAt(i));
    }
    
    StringBuilder reversedString = new StringBuilder();
    while (!stack.empty()) {
      reversedString.append(stack.pop());
    }
    
    return reversedString.toString();
  }

  public static void main(String[] args) {
    StringReversal strRev = new StringReversal();
    
    System.out.print("Enter a string: ");
    Scanner scanner = new Scanner(System.in);
    String aString = scanner.nextLine();
    System.out.println("\nThe reversed string is: " + strRev.reverse(aString));
  }
  
}
