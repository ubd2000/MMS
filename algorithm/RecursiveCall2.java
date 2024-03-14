/**
 * @author ubd2000
 */
public class RecursiveCall2 {
    public static void main(String[] args) {
        String text = "level";
        System.out.println(factorial(text));
    }

    public static boolean factorial(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) == text.charAt(text.length() - 1)) {
            return factorial(text.substring(1, text.length() - 1));
        } else {
            return false;
        }
    }
}