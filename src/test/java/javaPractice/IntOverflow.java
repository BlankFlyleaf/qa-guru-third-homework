package javaPractice;

public class IntOverflow {
    public static void main(String... args){
        int maxint = Integer.MAX_VALUE;
        int overflow = maxint + 1;
        System.out.println("Максимальный Int = " + maxint);
        System.out.println("Переполнение Int = " + overflow);
    }
}
