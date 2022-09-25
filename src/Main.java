public class Main {
    public static void main(String[] args) {
        System.out.println("11");
        String as = "8 / 2";

//        calc(as);
        System.out.println(calc(as));
    }
    public static String calc(String input){
        int a, b, result = 0;
        String operand;
        String[] tmp = input.split(" ");
        a = Integer.parseInt(tmp[0]);
        operand = (tmp[1]);
        b = Integer.parseInt(tmp[2]);

        switch (operand) {
            case "+": result = a + b;
                break;
            case "-": result = a - b;
                break;
            case "*": result = a * b;
                break;
            case "/": result = a / b;
                break;
        }


//            String retString = Integer.toString(result);
        return Integer.toString(result);
    }


}
