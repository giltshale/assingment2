import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.Scanner;

public class CheckPhoneNumberPattern {

    public static String correctPattern(String phoneNumber) {
        boolean correctStartOfPhoneNumber = phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '5';
        boolean onlyNumbers = false;
        for (int j = 0; j < phoneNumber.length(); j++)
            onlyNumbers = phoneNumber.charAt(j) == '0' ||
                    phoneNumber.charAt(j) == '1' ||
                    phoneNumber.charAt(j) == '2' || phoneNumber.charAt(j) ==
                    '3' || phoneNumber.charAt(j) == '4' || phoneNumber.charAt(j) == '5'
                    || phoneNumber.charAt(j) == '6' || phoneNumber.charAt(j) == '7'
                    || phoneNumber.charAt(j) == '8' || phoneNumber.charAt(j) == '9';

        if (onlyNumbers) {
            switch (phoneNumber.length()) {
                case 12:

                    if (phoneNumber.charAt(3) == '5' && phoneNumber.charAt(0) == '9'
                            && phoneNumber.charAt(1) == '7'
                            && phoneNumber.charAt(2) == '2') {
                        System.out.print("0");
                        for (int j = 3; j < 5; j++) {
                            System.out.print(phoneNumber.charAt(j));
                        }
                        System.out.print("-");
                        for (int j = 5; j < phoneNumber.length(); j++)
                            System.out.print(phoneNumber.charAt(j));
                        break;

                    }
                case 11:
                    if (correctStartOfPhoneNumber && phoneNumber.charAt(3) == '5') {
                        for (int i = 0; i < phoneNumber.length(); i++) {
                            System.out.print(phoneNumber.charAt(i));
                        }
                    }
                    break;
                case 10:
                    if (correctStartOfPhoneNumber) {
                        for (int i = 0; i < phoneNumber.length(); i++) {
                            if (i == 3) {
                                System.out.print("-");
                            }
                            System.out.print(phoneNumber.charAt(i));
                        }
                        break;
                    }

                default:
                    System.out.println("");
                    break;
            }
        }
        return "wrong input";
    }

    public static void main(String[] args) {
        correctPattern("972526645417");
    }
}
