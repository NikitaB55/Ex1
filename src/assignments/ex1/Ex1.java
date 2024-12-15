package assignments.ex1;
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
        if (isNumber(num)) {
            String[] arra = num.split("b");
            for (char c : arra[1].toCharArray()) {
                if (c >= '0' && c <= '9') {
                    ans = Integer.parseInt(Integer.toString(Integer.parseInt(arra[0], Integer.parseInt(arra[1])), 10));
                    break;
                } else if ((letterToNumber(c) >= 10 && letterToNumber(c) <= 16)) {
                    ans = Integer.parseInt(Integer.toString(Integer.parseInt(arra[0], letterToNumber(arra[1].charAt(0))), 10));
                    break;
                }
            }
        }
        return ans;
    }
    public static int basis(String a) {
        String[] arra = a.split("b");
        return number2Int(arra[1]);
    }
    public static int max(String a) {
        int max = -1;
        String[] arra = a.split("b");
        for (int i = 0; i < arra[0].length(); i++) {
            if(number2Int(String.valueOf(arra[0].charAt(i))) > max){
                max = number2Int(String.valueOf(arra[0].charAt(i)));
            }
        }
        return max;
    }
    public static int letterToNumber(char letter) {
        switch (letter) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            case 'G':
                return 16;
            default:
                // Return -1 for invalid input
                return -1;
        }
    }
    public static char numberToLetter(int num) {
        switch (num) {
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
            case 16:
                return 'G';
            default:
                // Return X for invalid input
                return 'X';
        }
    }
    public static boolean isNumericArray(String str) {
        if (str == null)
            return false;
        if (str.isEmpty())
            return false;
        for (char c : str.toCharArray())
            if ((c < '0' || c > '9') && (c < 'A' || c > 'G') || String.valueOf('c').isEmpty() ) {
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
        int sumb=0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == 'b'){
                sumb=sumb+1;
            }
        }
        if(sumb!=1 && sumb!=0){
            ans = false;
        }
        if(sumb==0 && !isNumericArray(a)){
            ans = false;
        }
        String[] arra = a.split("b");
        if(arra.length ==2){
            if(!isNumericArray(arra[0]) || !isNumericArray(arra[1])) {
                ans = false;
            }
        }
        if(arra.length == 2 && isNumericArray(arra[0]) && isNumericArray(arra[1])) {
            if ((basis(a) <= max(a)) || (basis(a)<=1 || basis(a)>=17)) {
                ans = false;
            }
        }
        else if(arra.length == 1 && isNumericArray(arra[0])){
            if(number2Int(arra[0]) > 9){
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
        int i = 0;
        StringBuilder str = new StringBuilder();
        if((base>16 || base<2) || num<0){
            ans = "";
            }
        else{
            Integer.toString(Integer.parseInt(String.valueOf(num), 10), base);
            str.insert(0, num);
            str.insert(String.valueOf(num).length()-1, 'b');
            if(base<=9){
                str.insert(String.valueOf(num).length(), base);
            }
            else{
                str.insert(String.valueOf(num).length(), numberToLetter(base));
            }
        }
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here

        ////////////////////
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        // add your code here

        ////////////////////
        return ans;
    }
}
