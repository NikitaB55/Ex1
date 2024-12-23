package assignments.ex1;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String base = "", num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 with a base from 2-G (or \"quit\" to end the program): ");
            num1 = sc.next();
            System.out.println();
            if (!num1.equals("quit")) {
                System.out.printf(num1 + " is number: " + Ex1.isNumber(num1) + ", value = " + Ex1.number2Int(num1));
                System.out.println("Enter a string as number#2 with a base from 2-G (or \"quit\" to end the program): ");
                num2 = sc.next();
                System.out.println();
                if (!num2.equals("quit")) {
                    System.out.printf(num2 + " is number: " + Ex1.isNumber(num2) + ", value = " + Ex1.number2Int(num2));
                    System.out.println("Enter a a base (a number 2-16): ");
                    base = sc.next();
                    System.out.println();
                    if ((Integer.parseInt(base) > 1 && Integer.parseInt(base) < 10)) {
                        String sum = (Integer.toString(Integer.parseInt(String.valueOf(Ex1.number2Int(num1) + Ex1.number2Int(num2)), 10), Integer.parseInt(base)) + "b" + base);
                        System.out.println(num1 + " + " + num2 + " = " + sum);
                        String mul = (Integer.toString(Integer.parseInt(String.valueOf(Ex1.number2Int(num1) * Ex1.number2Int(num2)), 10), Integer.parseInt(base)) + "b" + base);
                        System.out.println(num1 + " * " + num2 + " = " + mul);
                        String[] arr1 = {num1, num2, sum, mul};
                        System.out.println("Max number over [" + num1 + "," + num2 + "," + sum + "," + mul + "] is: " + arr1[Ex1.maxIndex(arr1)]);
                    }
                    else if ((Integer.parseInt(base) > 10 && Integer.parseInt(base) < 17)) {
                        String sum = (Integer.toString(Integer.parseInt(String.valueOf(Ex1.number2Int(num1) + Ex1.number2Int(num2)), 10), Integer.parseInt(base)) + "b" + Ex1.numberToLetter(Integer.parseInt(base)));
                        System.out.println(num1 + " + " + num2 + " = " + sum);
                        String mul = (Integer.toString(Integer.parseInt(String.valueOf(Ex1.number2Int(num1) * Ex1.number2Int(num2)), 10), Integer.parseInt(base)) + "b" + Ex1.numberToLetter(Integer.parseInt(base)));
                        System.out.println(num1 + " * " + num2 + " = " + mul);
                        String[] arr1 = {num1, num2, sum, mul};
                        System.out.println("Max number over [" + num1 + "," + num2 + "," + sum + "," + mul + "] is: " + arr1[Ex1.maxIndex(arr1)]);
                    }
                    else if (Integer.parseInt(base) == 10) {
                        String sum = (Integer.toString(Integer.parseInt(String.valueOf(Ex1.number2Int(num1) + Ex1.number2Int(num2)), 10), Integer.parseInt(base)));
                        System.out.println(num1 + " + " + num2 + " = " + sum);
                        String mul = (Integer.toString(Integer.parseInt(String.valueOf(Ex1.number2Int(num1) * Ex1.number2Int(num2)), 10), Integer.parseInt(base)));
                        System.out.println(num1 + " * " + num2 + " = " + mul);
                        String[] arr2 = {num1, num2, sum, mul};
                        System.out.println("Max number over [" + num1 + "," + num2 + "," + sum + "," + mul + "] is: " + arr2[Ex1.maxIndex(arr2)]);
                    }
                }
            }
        }
        System.out.println("quiting now...");
    }
}
