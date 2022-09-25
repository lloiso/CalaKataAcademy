public class Main {
    public static void main(String[] args) {
        System.out.println(56 % 10);
        String as = "8 / 2";

//        calc(as);
        System.out.println(calc(as));
        for (int i = 1; i < 99; i++) {
            String tmp = Integer.toString(i);
            System.out.println(handlerArabianNumberToRomeNumber(tmp) + " " + i);
        }

        System.out.println(handlerRomeNumberToArabianNumber("I"));
        System.out.println(handlerRomeNumberToArabianNumber("II"));
        System.out.println(handlerRomeNumberToArabianNumber("III"));
        System.out.println(handlerRomeNumberToArabianNumber("IV"));
        System.out.println(handlerRomeNumberToArabianNumber("V"));
        System.out.println(handlerRomeNumberToArabianNumber("VI"));
        System.out.println(handlerRomeNumberToArabianNumber("VII"));
        System.out.println(handlerRomeNumberToArabianNumber("VIII"));
        System.out.println(handlerRomeNumberToArabianNumber("IX"));
        System.out.println(handlerRomeNumberToArabianNumber("X"));
    }

    public static String calc(String input) {
        int a, b, result = 0;
        String operand;
        String[] tmp = input.split(" ");

        a = Integer.parseInt(tmp[0]);
        operand = (tmp[1]);
        b = Integer.parseInt(tmp[2]);

        switch (operand) {
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
        }
        return Integer.toString(result);
    }
}
