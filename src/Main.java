public class Main {
    public static void main(String[] args) {
        System.out.println("11");
        String as = "8 / 2";

//        calc(as);
        System.out.println(calc(as));
        for (int i = 1; i < 19; i++) {
            String tmp = Integer.toString(i);
            System.out.println(handlerArabianNumberToRomeNumber(tmp));
        }
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
        String romeNum = "I";
        int num = Integer.parseInt(incoming);
        if (num > 0 && num < 4) {
            for (int i = 1; i < num; i++) {
                romeNum = romeNum + "I";
            }
        } else if (num == 4) {
            romeNum = romeNum + "V";
        } else if (num > 4 && num < 9) {
            romeNum = "V";
            for (int i = 5; i < num; i++) {
                romeNum = romeNum + "I";
            }
        } else if (num == 9) {
            romeNum = romeNum + "X";
        } else if (num > 9 && num < 14) {
            romeNum = "X";
            for (int i = 10; i < num; i++) {
                romeNum = romeNum + "I";
            }
        }else if (num == 14){
            romeNum = "XIV";
        }else if (num > 14 && num < 19){
            romeNum = "XV";
            for (int i = 15; i < num; i++) {
                romeNum = romeNum + "I";
            }
        }
        return romeNum;
    }
    public static String handlerRomeNumberToArabianNumber(String incoming) {
        return "1";
    }
}
