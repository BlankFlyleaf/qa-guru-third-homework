package javaPractice;

public class FloatingOverflow {
    public static void main(String... args){
        double maxDouble = Double.MAX_VALUE;
        double overflow = maxDouble * 2.0;
        System.out.println("Бесконечный Double = " + overflow);
    }
}
