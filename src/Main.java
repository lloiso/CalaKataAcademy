import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println(56 % 10);
        String input = "x - i";
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();


        try {
            System.out.println(calc(input));
        } catch (MoreTenNumber e) {
            System.out.println("fuck");
        }


        scanner.close();


//        for (int i = 1; i < 101; i++) {
//            String tmp = Integer.toString(i);
//            System.out.println(handlerArabianNumberToRomeNumber(tmp) + " " + i);
//        }

//        System.out.println(handlerRomeNumberToArabianNumber("I"));
//        System.out.println(handlerRomeNumberToArabianNumber("II"));
//        System.out.println(handlerRomeNumberToArabianNumber("III"));
//        System.out.println(handlerRomeNumberToArabianNumber("IV"));
//        System.out.println(handlerRomeNumberToArabianNumber("V"));
//        System.out.println(handlerRomeNumberToArabianNumber("VI"));
//        System.out.println(handlerRomeNumberToArabianNumber("VII"));
//        System.out.println(handlerRomeNumberToArabianNumber("VIII"));
//        System.out.println(handlerRomeNumberToArabianNumber("IX"));
//        System.out.println(handlerRomeNumberToArabianNumber("X"));
    }

    public static String calc(String input) throws MoreTenNumber {
        int a, b, result = 0;
        String operator;
        String[] tmp = input.split(" ");
        a = Integer.parseInt(handlerRomeNumberToArabianNumber(tmp[0]));
        operator = (tmp[1]);
        b = Integer.parseInt(handlerRomeNumberToArabianNumber(tmp[2]));

        System.out.println(a);
        System.out.println(b);

        if (a > 10 || b > 10) {
            throw new MoreTenNumber("введено значение больше 10");
        } else {

            switch (operator) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
            }
            return handlerArabianNumberToRomeNumber(Integer.toString(result));
        }
    }

    public static String handlerArabianNumberToRomeNumber(String incoming) {
        String romeNum = "";
        String romeDecimalNum = "";
        int num = Integer.parseInt(incoming) % 10;
        int decimalNum = Integer.parseInt(incoming) / 10;

        if (decimalNum > 0 && decimalNum < 4) {
            romeDecimalNum = "X";
            for (int i = 1; i < decimalNum; i++) {
                romeDecimalNum = romeDecimalNum + "X";
            }
        } else if (decimalNum == 4) {
            romeDecimalNum = "X";
            romeDecimalNum = romeDecimalNum + "L";
        } else if (decimalNum > 4 && decimalNum < 9) {
            romeDecimalNum = "L";
            for (int i = 5; i < decimalNum; i++) {
                romeDecimalNum = romeDecimalNum + "X";
            }
        } else if (decimalNum == 9) {
            romeDecimalNum = "X";
            romeDecimalNum = romeDecimalNum + "C";
        } else if (decimalNum == 10) {
            romeDecimalNum = "С";
        }

        if (num > 0 && num < 4) {
            romeNum = "I";
            for (int i = 1; i < num; i++) {
                romeNum = romeNum + "I";
            }
        } else if (num == 4) {
            romeNum = "I";
            romeNum = romeNum + "V";
        } else if (num > 4 && num < 9) {
            romeNum = "V";
            for (int i = 5; i < num; i++) {
                romeNum = romeNum + "I";
            }
        } else if (num == 9) {
            romeNum = "I";
            romeNum = romeNum + "X";
        }
        return romeDecimalNum + romeNum;
    }

    public static String handlerRomeNumberToArabianNumber(String incoming) {
        int result = 0;
        incoming = incoming.toUpperCase();

        switch (incoming.charAt(0)) {
            case 'I':
                result = 1;
                for (int i = 1; i < incoming.length(); i++) {
                    if (incoming.charAt(i) == 'I') {
                        result++;
                    } else if (incoming.charAt(i) == 'V') {
                        result = 4;
                    } else if (incoming.charAt(i) == 'X') {
                        result = 9;
                    }
                }
                break;
            case 'V':
                result = 5;
                for (int i = 1; i < incoming.length(); i++) {
                    if (incoming.charAt(i) == 'I') {
                        result++;
                    }
                }
                break;
            case 'X':
                result = 10;
                break;
//            default:
//                try {
//                    throw new IOException();
//                } catch (IOException e) {
//                    System.out.println("not roman num");
//                }
        }
        return Integer.toString(result);
    }
}
