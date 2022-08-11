package utils;

import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

    public boolean checkInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            //Not an integer
        }
        return false;
    }

    public boolean checkDouble(String input) {
        try {
            Double num = Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }
}
