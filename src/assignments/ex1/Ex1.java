package assignments.ex1;

import javax.print.attribute.standard.NumberUp;
import java.util.Locale;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base),
 * “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */

    public static int number2Int(String num) {
        int ans = -1;
        String[] arra = num.split("b");
        if (arra.length == 2) {
            for (char c : arra[1].toCharArray()) {
                if (c >= '0' && c <= '9') {
                    // Converts the number in the given base to an integer
                    ans = Integer.parseInt(Integer.toString(Integer.parseInt(arra[0], Integer.parseInt(arra[1])), 10));
                    break;
                } else if ((letterToNumber(c) >= 10 && letterToNumber(c) <= 16)) {
                    // Converts the number using the base given by the second part of the string
                    ans = Integer.parseInt(Integer.toString(Integer.parseInt(arra[0], letterToNumber(arra[1].charAt(0))), 10));
                    break;
                }
            }
        } else if (arra.length == 1) {
            if (arra[0].charAt(0) >= '0' && arra[0].charAt(0) <= '9') {
                // Converts from base 10 to integer
                ans = Integer.parseInt(Integer.toString(Integer.parseInt(arra[0], 10), 10));
            }
            else if (arra[0].charAt(0) >= 'A' && arra[0].charAt(0) <= 'G') {
                // Converts letter (A-G) to corresponding integer value
                ans = Integer.parseInt(Integer.toString(Integer.parseInt(String.valueOf(letterToNumber(arra[0].charAt(0))), 10), 10));
            }
        }
        return ans;
    }

    public static int basis(String a) {
        // Extracts the base (after 'b') from the string and returns its integer representation
        String[] arra = a.split("b");
        return number2Int(arra[1]);
    }

    public static int max(String a) {
        int max = -1;
        String[] arra = a.split("b");
        for (int i = 0; i < arra[0].length(); i++) {
            // Finds the maximum numeric value among the characters in the string
            if (number2Int(String.valueOf(arra[0].charAt(i))) > max) {
                max = number2Int(String.valueOf(arra[0].charAt(i)));
            }
        }
        return max;
    }

    public static int letterToNumber(char letter) {
        // Converts a letter (A-G) to its corresponding numeric value (10-16)
        switch (letter) {
            case 'A': return 10;
            case 'B': return 11;
            case 'C': return 12;
            case 'D': return 13;
            case 'E': return 14;
            case 'F': return 15;
            case 'G': return 16;
            default: // Return -1 for invalid input
                return -1;
        }
    }

    public static char numberToLetter(int num) {
        // Converts a number (10-16) to its corresponding letter (A-G)
        switch (num) {
            case 10: return 'A';
            case 11: return 'B';
            case 12: return 'C';
            case 13: return 'D';
            case 14: return 'E';
            case 15: return 'F';
            case 16: return 'G';
            default: // Return 'X' for invalid input
                return 'X';
        }
    }

    public static boolean isNumericArray(String str) {
        if (str == null)
            return false;
        if (str.isEmpty())
            return false;
        // Checks if the string consists only of valid characters (0-9 or A-G)
        for (char c : str.toCharArray())
            if ((c < '0' || c > '9') && (c < 'A' || c > 'G') || String.valueOf('c').isEmpty()) {
                return false;
            }
        return true;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        int sumb = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'b') {
                sumb = sumb + 1;
            }
        }
        if (sumb != 1 && sumb != 0) {
            ans = false;
        }
        if (sumb == 0 && !isNumericArray(a)) {
            ans = false;
        }
        String[] arra = a.split("b");
        if (arra.length == 2) {
            if (!isNumericArray(arra[0]) || !isNumericArray(arra[1])) {
                ans = false;
            }
        }
        if ((arra.length == 2) && (isNumericArray(arra[0]) && isNumericArray(arra[1]))) {
            if ((basis(a) <= max(a)) || (basis(a) <= 1 || basis(a) >= 17)) {
                ans = false;
            }
        } else if (arra.length == 1 && isNumericArray(arra[0])) {
            if (!Character.isDigit(a.charAt(0))) {
                ans = false;
            }
        }
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        String numr = "";
        int i = 0;
        StringBuilder str = new StringBuilder();
        if ((base > 16 || base < 2) || num < 0) {
            ans = "";
        } else if (base == 10) {
            // Converts the number to a string in base 10
            numr = (Integer.toString(Integer.parseInt(String.valueOf(num), 10), base)).toUpperCase(Locale.ROOT);
            str.insert(0, numr);
        } else {
            // Converts the number to a string in a given base (2-16)
            numr = (Integer.toString(Integer.parseInt(String.valueOf(num), 10), base)).toUpperCase(Locale.ROOT);
            str.insert(0, numr);
            str.insert(String.valueOf(numr).length(), 'b');
            if (base <= 9) {
                str.insert(String.valueOf(numr).length() + 1, base);
            } else {
                str.insert(String.valueOf(numr).length() + 1, numberToLetter(base));
            }
        }
        ans = String.valueOf(str);
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = false;
        if (number2Int(n1) == number2Int(n2)) {
            ans = true;
        }
        return ans;
    }

    /**
     * This static function searches for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or non-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            // Finds the index of the element with the largest value
            if (number2Int(arr[i]) > max) {
                max = number2Int(arr[i]);
                ans = i;
            }
        }
        return ans;
    }
}