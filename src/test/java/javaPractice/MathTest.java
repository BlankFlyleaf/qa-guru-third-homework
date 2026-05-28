package javaPractice;

public class MathTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int sum = a + b;
        int dif = b - a;
        int mul = a * b;
        int div = b / a;

        System.out.println("Сумма = " + sum);
        System.out.println("Разность = " + dif);
        System.out.println("Умножение = " + mul);
        System.out.println("Деление = " + div);

        double c = 2.2;
        double math = (c + b)*c/a;

        System.out.println("Результат операций над double = " + math);

        int d = 10;
        int e = 22;
        System.out.println("a больше b = " + (a>b));
        System.out.println("a меньше b = " + (a<b));
        System.out.println("a больше или равно d = " + (a>=d));
        System.out.println("a меньше или равно e = " + (a<=e));

        float maxFloat = Float.MAX_VALUE;
        float minFloat = Float.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;
        double minDouble = Double.MIN_VALUE;
        System.out.println("Максимальный float = " + maxFloat);
        System.out.println("Минимальный float = " + minFloat);
        System.out.println("Максимальный double = " + maxDouble);
        System.out.println("Минимальный double = " + minDouble);
    }
}
