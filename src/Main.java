import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();


        try {
            System.out.println(calc(input));
        } catch (MoreTenNumber e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("деление на 0");
        } catch (LessOneNumException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        scanner.close();
    }

    public static String calc(String input) throws Exception {
        String[] tmp = input.split(" ");
        if (tmp.length < 3){
            throw new Exception("строка не является математической операцией");
        }
        if (tmp.length > 3){
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String out = null;

        switch (checkNum(tmp[0]) + checkNum(tmp[2])) {
            case 0:
                out = arabianCalc(input);
                break;
            case 1:
                throw new Exception("используются одновременно разные системы счисления");
            case 2:
                out = romanianCalc(input);
                break;
        }
        return out;
    }

    public static int checkNum(String checkStr) {
        int a = 0;
        checkStr = checkStr.toUpperCase();

        for (int i = 0; i < checkStr.length(); i++) {
            char ch = checkStr.charAt(i);
            if (ch == 'I' || ch == 'V' || ch == 'X') {
                a = 1;
            }
        }
        return a;
    }


    public static String arabianCalc(String input) throws MoreTenNumber, ArithmeticException {
        int a, b, result = 0;
        String operator;
        String[] tmp = input.split(" ");
        a = Integer.parseInt(tmp[0]);
        operator = (tmp[1]);
        b = Integer.parseInt(tmp[2]);

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
            return Integer.toString(result);
        }

    }

    public static String romanianCalc(String input) throws MoreTenNumber, LessOneNumException {
        int a, b, result = 0;
        String out = null;
        String operator;
        String[] tmp = input.split(" ");
        a = Integer.parseInt(handlerRomeNumberToArabianNumber(tmp[0]));
        operator = (tmp[1]);
        b = Integer.parseInt(handlerRomeNumberToArabianNumber(tmp[2]));

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
            if (result < 1) {
                throw new LessOneNumException("в римской системе нет отрицательных чисел");
            } else out = handlerArabianNumberToRomeNumber(Integer.toString(result));

            return out;
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
                for (int i = 1; i < incoming.length(); i++) {
                    if (incoming.charAt(i) == 'I') {
                        result++;
                    } else if (incoming.charAt(i) == 'V') {
                        result = 15;
                    } else if (incoming.charAt(i) == 'X') {
                        result = 20;
                    }
                }
                break;
        }
        return Integer.toString(result);
    }
}
