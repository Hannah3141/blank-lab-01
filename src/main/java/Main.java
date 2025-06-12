package main.java;

import java.util.Scanner;

/** An implementation of a Caesar shift cipher. */
public class Main {

  /**
   * Should print the decoded message after applying
   * a Caesar shift cipher. Please see the README
   * for a description of the input(s) and output(s).
   *
   * @param args the command-line arguments (always empty)
   */
  public static void main(String[] args) {
    // TODO: print the decoded message
    Scanner input = new Scanner(System.in);

    int length = input.nextInt();
    input.nextLine();

    String message = input.nextLine();

    int shift = input.nextInt();
    input.nextLine();

    String result = "";
    for(int i = 0; i < message.length(); i++){
      int letter = message.charAt(i);
      char newLetter = (char)(letter - shift);
      result += newLetter;
    }

    System.out.println(result);
  }
}
