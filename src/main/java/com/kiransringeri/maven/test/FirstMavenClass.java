package com.kiransringeri.maven.test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstMavenClass {

  /**
   * Method with some java8 features.
   */
  public void java8Features() {
    String[] strArray = {"A", "B", "C", "D"};
    List<String> list = Arrays.asList(strArray);
    String result = list.stream().collect(Collectors.joining(","));
    System.out.println(result);
  }
  /*
   * // Method to test the FindBug plugin public void infiniteRecursiveLoop() {
   * infiniteRecursiveLoop(); }
   */

  // Method to test PMD plugin -
  /*
   * public void emptyTryCatch() { try {
   * 
   * }catch(Throwable th) {
   * 
   * } }
   */
  /**
   * The main method.
   * 
   * @param args input file
   */
  public static void main(String[] args) {
    Scanner scanner = null;
    try {
      if (args.length > 1) {
        System.err.println("Usage: " + FirstMavenClass.class.getSimpleName() + " [<input file>]");
        System.exit(1);
      }
      if (args.length == 1) {
        String fileName = args[0];
        File file = new File(fileName);
        if (!file.exists()) {
          System.err.println("File \"" + fileName + "\" doesn't exist");
          System.exit(1);
        }
        scanner = new Scanner(file, "UTF-8");
      } else {
        scanner = new Scanner(System.in, "UTF-8");
      }

      while (true) {
        try {
          String str = scanner.nextLine();

          if (str == null || str.trim().length() == 0) { // Invalid input
            continue;
          }
          String[] tokens = str.split("\\s");
          String action = tokens[0];
          if ("create_parking_lot".equals(action)) {
            System.out.println("Created a parking lot with " + tokens[1]);
          } else if ("park".equals(action)) {
            System.out.println("Allocated " + tokens[1] + "," + tokens[2]);
          } else if ("leave".equals(action)) {
            System.out.println("De-allocated " + tokens[1]);
          } else if ("registration_numbers_for_cars_with_colour".equals(action)) {
            System.out.println("Reg Numbers for color " + tokens[1]);
          } else if ("slot_numbers_for_cars_with_colour".equals(action)) {
            System.out.println("Slot Numbers for color " + tokens[1]);
          } else {
            // Invalid action
            System.out.println("Invalid input, ignoring this");
            continue;
          }

        } catch (NoSuchElementException nse) {
          break;
        }
      }
    } catch (Throwable th) {
      th.printStackTrace();
    } finally {
      if (scanner != null) {
        scanner.close();
      }
    }
  }

  /**
   * Divides the numbers.
   * @param divident the dividend
   * @param divisor the divisor
   * @return
   */
  public int divideNumbers(int divident, int divisor) {
    if (divisor == 0) 
      throw new IllegalArgumentException("Divisor can't be zero");
    
    return divident / divisor;
  }
}
