package pl.app;

public class modelApp {
    public static double calculate(double numberOne, double numberTwo, String operator) {
        switch (operator) {
            case "+":
                return add(numberOne, numberTwo);
            case "-":
                return substract(numberOne, numberTwo);
            case "÷":
                return divide(numberOne, numberTwo);
            case "x":
                return multipy(numberOne, numberTwo);
            case "=":
                return numberOne;
        }
        return 0;
    }

    private static double add(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    private static double substract(double numberOne, double numberTwo) { return numberOne - numberTwo; }

    private static double divide(double numberOne, double numberTwo) {
        return numberOne / numberTwo;
    }

    private static double multipy(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    public static boolean checkInteger(double result) {
        if (result == (int) result)
            return true;
        else return false;
    }

    public static boolean checkDot(String number) {
        if (!number.contains("."))
            return true;
        else return false;
    }
}
