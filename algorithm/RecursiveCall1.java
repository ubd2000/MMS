/**
 * @author ubd2000
 */
public class RecursiveCall1 {
    public static void main(String[] args) {
        int returnValue = 1;
        for (int i = 0; i < 10; i++) {
            returnValue = factorial(i);
        }
        System.out.println(returnValue);
    }

    public static int factorial(int num) {
        if (num <= 1) {
            return num;
        } else {
            return num * factorial(num - 1);
        }
    }
}
