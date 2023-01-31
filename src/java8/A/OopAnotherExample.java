package java8.A;

public class OopAnotherExample {
    public static void main(String[] args) {
        final CalculatorService add = new CalculatorService(new Addition());
        final CalculatorService sub = new CalculatorService(new Subtraction());
        final CalculatorService mul = new CalculatorService(new Multiplication());
        final CalculatorService div = new CalculatorService(new Division());

        System.out.println(add.calculate(1, 1));
        System.out.println(sub.calculate(1,1));
        System.out.println(mul.calculate(1,1));
        System.out.println(div.calculate(1,1));
    }
}

interface Calculation {
    int calculate(int num1, int num2);
}

class Addition implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class Subtraction implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
class Multiplication implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}
class Division implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 / num2;
    }
}


class CalculatorService {
    private final Calculation calculation;

    public CalculatorService(final Calculation calculation) {
        this.calculation = calculation;
    }

    public int calculate(int num1, int num2){
        return calculation.calculate(num1, num2);
    }
}